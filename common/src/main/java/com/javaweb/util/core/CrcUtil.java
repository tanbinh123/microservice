package com.javaweb.util.core;

//国家开票标准
public class CrcUtil {

    public static String getCrcSign(byte[] bytes) {
    	int crc_value = calculateCRC(bytes);
    	//System.out.println(Integer.toHexString(crc_value));//不推荐截取最后四位
        byte[] byteStr = new byte[4];
        byteStr[0] = (byte) ((crc_value & 0x000000ff));
        byteStr[1] = (byte) ((crc_value & 0x0000ff00) >>> 8);
        //System.out.printf("%02X\n%02X",byteStr[0],byteStr[1]);
        String crcOut = String.format("%02X",byteStr[1])+String.format("%02X",byteStr[0]);
        return crcOut;
    }
    
    //名称</>纳税人识别号</>地址电话</>开户行及账号</>
    //XXX有限公司XXX分公司</>123456789ABC</>XXX号1234-56789</>XX银行XX分行营业部123456789087654321</>
	public static String getCrcCode(String info) throws Exception {
		String crcSign = getCrcSign(info.getBytes());
	  	crcSign = info + crcSign;
	  	crcSign = SecretUtil.base64EncoderString(crcSign,"UTF-8");
	  	StringBuilder sb = new StringBuilder();
	  	sb.append("$01").append(crcSign).append("$");
	  	return sb.toString();
	}
	
    //crc值计算
    public static int calculateCRC(byte[] bytes) {
    	int i;
        int crc_value = 0;
        for (int len = 0; len < bytes.length; len++) {
    	for (i = 0x80; i != 0; i >>= 1) {
    	    if ((crc_value & 0x8000) != 0) {
    		crc_value = (crc_value << 1) ^ 0x8005;
    	    } else {
    		crc_value = crc_value << 1;
    	    }
    	    if ((bytes[len] & i) != 0) {
    		crc_value ^= 0x8005;
    	    }
    	}
        }
        return crc_value;
    }

}
