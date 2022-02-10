package com.javaweb.web.controller;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import com.javaweb.base.BaseInject;

@RestController
public class TestController extends BaseInject {
	
	@PostConstruct
	public void init(){
		System.out.println("TestController init");
	}
	
	/**
    @Autowired
    private LogServerApi logServerApi;
    
    //测试Get
    @GetMapping(value={"/getTest","/getTest2"})
    public BaseResponseResult getTest() {
		return new BaseResponseResult(200,"success",null);
    }
    
    //测试Put
    @PutMapping("/putTest")
    public BaseResponseResult putTest(@RequestBody RoleModule roleModule) {
		return new BaseResponseResult(200,"success",roleModule);
    }
    
    //测试Delete
    @DeleteMapping("/deleteTest")
    public BaseResponseResult deleteTest() {
		return new BaseResponseResult(200,"success",null);
    }
    
    //测试Post
    @PostMapping("/postTest")
    public BaseResponseResult postTest(@RequestBody RoleModule roleModule) {
		return new BaseResponseResult(200,"success",roleModule);
    }
    
    //获取二维码
    @GetMapping("/getQrCode")
    public void getQrCode(HttpServletRequest request,HttpServletResponse response){
    	try{
    		//QRCodeWriterWithoutWrite qrCodeWriter = new QRCodeWriterWithoutWrite();
    		QRCodeWriter qrCodeWriter = new QRCodeWriter();
    		BitMatrix bitMatrix = qrCodeWriter.encode(SystemConstant.PROJECT_GITHUB_URL,BarcodeFormat.QR_CODE,180,180);
    		MatrixToImageWriter.writeToStream(bitMatrix,"jpg",response.getOutputStream());
    	}catch(Exception e){
    		//do nothing
    	}
    }
    
    //测试eureka微服务间的通信
    @GetMapping("/eurekaTest")
    public BaseResponseResult eurekaTest(HttpServletRequest request) {
        LogServerApiEntity logServerApiEntity = new LogServerApiEntity();
        logServerApiEntity.setUsername("abc");
        logServerApiEntity.setPassword("123");
        String part1 = logServerApi.test(logServerApiEntity);
        String part2 = discoveryClient.getInstances("eureka-client-log").toString();
        String part3 = eurekaClient.getInstancesByVipAddress("eureka-client-log",false).toString();
        String part4 = String.valueOf(request.getServerPort());
        return new BaseResponseResult(200,String.join(CommonConstant.COMMA,part1,part2,part3,part4),null);
    }
    */
    
}

//去四周白边
class QRCodeWriterWithoutWrite implements Writer {
    
    public QRCodeWriterWithoutWrite() {
    	
    }

	public BitMatrix encode(String contents, BarcodeFormat format, int width, int height) throws WriterException {
        return this.encode(contents, format, width, height, null);
    }

    public BitMatrix encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType,?> hints) throws WriterException {
        if (contents.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (format != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(format)));
        } else if (width >= 0 && height >= 0) {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int quietZone = 4;
            if (hints != null) {
                if (hints.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                    errorCorrectionLevel = ErrorCorrectionLevel.valueOf(hints.get(EncodeHintType.ERROR_CORRECTION).toString());
                }
                if (hints.containsKey(EncodeHintType.MARGIN)) {
                    quietZone = Integer.parseInt(hints.get(EncodeHintType.MARGIN).toString());
                }
            }
            return renderResult(Encoder.encode(contents, errorCorrectionLevel, hints), width, height, quietZone);
        } else {
            throw new IllegalArgumentException("Requested dimensions are too small: " + width + 'x' + height);
        }
    }

    private static BitMatrix renderResult(QRCode code, int width, int height, int quietZone) {
        ByteMatrix input = code.getMatrix();
        if (input == null) {
            throw new IllegalStateException();
        }
        int inputWidth = input.getWidth();
        int inputHeight = input.getHeight();
        int qrWidth = inputWidth ;
        int qrHeight = inputHeight;
        int outputWidth = Math.max(width, qrWidth);
        int outputHeight = Math.max(height, qrHeight);
        int multiple = Math.min(outputWidth / qrWidth, outputHeight / qrHeight);
        // Padding includes both the quiet zone and the extra white pixels to
        // accommodate the requested
        // dimensions. For example, if input is 25x25 the QR will be 33x33
        // including the quiet zone.
        // If the requested size is 200x160, the multiple will be 4, for a QR of
        // 132x132. These will
        // handle all the padding from 100x100 (the actual QR) up to 200x160.
        int leftPadding = (outputWidth - (inputWidth * multiple)) / 2;
        int topPadding = (outputHeight - (inputHeight * multiple)) / 2;
        if(leftPadding >= 0 ) {
            outputWidth = outputWidth - 2 * leftPadding ;
            leftPadding = 0;
        }
        if(topPadding >= 0) {
            outputHeight = outputHeight - 2 * topPadding;
            topPadding = 0;
        }
        BitMatrix output = new BitMatrix(outputWidth, outputHeight);
        for (int inputY = 0, outputY = topPadding; inputY < inputHeight; inputY++, outputY += multiple) {
            // Write the contents of this row of the barcode
            for (int inputX = 0, outputX = leftPadding; inputX < inputWidth; inputX++, outputX += multiple) {
                if (input.get(inputX, inputY) == 1) {
                    output.setRegion(outputX, outputY, multiple, multiple);
                }
            }
        }
        return output;
    }
    
}
