import { CommonConstant } from '../constant/CommonConstant';

const jsrsasign = require('jsrsasign');
const crypto = require('crypto-js');

const STRING_ARRAY:Array<string> = [
    '0','1','2','3','4','5','6','7','8','9',
    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
];

/**
 * 参考
 * https://cryptojs.gitbook.io/docs
 */
export class SecretUtil {

  //获得随机干扰字符串
  public static getNonce(length:number,ignoreCase:boolean):string {
      let out = CommonConstant.EMPTY;
      for(let i=0;i<length;i++){
          let randomIndex = Math.ceil(Math.random()*length)-1;
          if(ignoreCase){
              out += STRING_ARRAY[randomIndex].toLowerCase();
          }else{
              out += STRING_ARRAY[randomIndex];
          }
      }
      return out;
  }

  //获得md5值
  public static getMd5(data:string):string {
      return crypto.MD5(data).toString(crypto.enc.Hex);
  }

  //rsa公钥加密
  //let publicKey = '-----BEGIN PUBLIC KEY-----MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3XSdz1MnzazBEN5KOfTx0IyVJZ5wb57isrCuHDhnYXwtmdhQalgII0fozeeFpMpAvlnmHC1kpW7XVGvZnLx3bWbCEbf+pMSW4kmQuI+5cxRUJbCl7sdaODBrINgERHPICVC18AJLThEVMHyjuR6Jn4zQmyYNbReSktY/BrFTvMQIDAQAB-----END PUBLIC KEY-----'
  public static rsaEncrypt(data:string,publicKey:string):string {
    publicKey = '-----BEGIN PUBLIC KEY-----' + publicKey + '-----END PUBLIC KEY-----';
    let publicString = jsrsasign.KEYUTIL.getKey(publicKey);
    let encryptString = jsrsasign.KJUR.crypto.Cipher.encrypt(data,publicString);
    //console.log(crypto.enc.Utf8.parse(data));
    //console.log(crypto.enc.Hex.stringify(encryptString));
    let words = crypto.enc.Hex.parse(encryptString);
    //console.log(words);
    words = crypto.enc.Base64.stringify(words);
    //console.log(words);
    return words;
  }

  //rsa私钥验签
  //let privateKey = '-----BEGIN PRIVATE KEY-----MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3XSdz1MnzazBEN5KOfTx0IyVJZ5wb57isrCuHDhnYXwtmdhQalgII0fozeeFpMpAvlnmHC1kpW7XVGvZnLx3bWbCEbf+pMSW4kmQuI+5cxRUJbCl7sdaODBrINgERHPICVC18AJLThEVMHyjuR6Jn4zQmyYNbReSktY/BrFTvMQIDAQAB-----END PRIVATE KEY-----'
  public static rsaSign(data:string,privateKey:string):string {
    privateKey = '-----BEGIN PRIVATE KEY-----' + privateKey + '-----END PRIVATE KEY-----';
    let key = jsrsasign.KEYUTIL.getKey(privateKey);
    let signature = new jsrsasign.KJUR.crypto.Signature({alg:'SHA1withRSA',prvkeypem:privateKey});
    signature.init(key);
    signature.updateString(data);
    let sign = signature.sign();
    let words = crypto.enc.Hex.parse(sign);
    //console.log(words);
    words = crypto.enc.Base64.stringify(words);
    //console.log(words);
    return words;
  }

  //aes加密
  public static cryptoAesEncrypt(data:string,secretKey:string):string {
    let iv = SecretUtil.getCryptoIV();
    let key = crypto.enc.Hex.parse(crypto.enc.Utf8.parse(secretKey).toString(crypto.enc.Hex));
    let encryptMode:any = {mode:crypto.mode.ECB,padding:crypto.pad.Pkcs7,iv:iv};
    return crypto.AES.encrypt(data,key,encryptMode).toString();
  }

  //aes解密
  public static cryptoAesDecrypt(secretData:string,secretKey:string):string {
    let iv = SecretUtil.getCryptoIV();
    let key = crypto.enc.Hex.parse(crypto.enc.Utf8.parse(secretKey).toString(crypto.enc.Hex));
    let decryptMode:any = {mode:crypto.mode.ECB,padding:crypto.pad.Pkcs7,iv:iv};
    return crypto.AES.decrypt(secretData,key,decryptMode).toString(crypto.enc.Utf8);
  }

  //适配JAVA的[AES/ECB/PKCS5Padding]模式
  private static getCryptoIV():any {
    let out = CommonConstant.EMPTY;
    let tmpArray = [1,2,3,4,5,6,7,8];
    for(let i=0;i<tmpArray.length;i++) {
      let one = tmpArray[i].toString(2),v = one.match(/^1+?(?=0)/);
      if(v && one.length == 8) {
        let bytesLength = v[0].length;
        let store = tmpArray[i].toString(2).slice(7 - bytesLength);
        for(let st=1;st<bytesLength;st++) {
          store += tmpArray[st+i].toString(2).slice(2);
        }
        out += String.fromCharCode(parseInt(store,2));
        i += bytesLength-1;
      } else {
        out += String.fromCharCode(tmpArray[i]);
      }
    }
    return crypto.enc.Latin1.parse(out);
  }

}
