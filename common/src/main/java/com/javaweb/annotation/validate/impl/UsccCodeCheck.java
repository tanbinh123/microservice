package com.javaweb.annotation.validate.impl;

import com.javaweb.util.core.StringUtil;

public class UsccCodeCheck {
	
    private final static int USCC_LEN = 18;
    
    private final static int[] WEIGHT = {1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28};//用于存放权值

    public static boolean check(String usccCode) {
       	if(StringUtil.isEmpty(usccCode)){
    		return false;
    	}
        if (usccCode.length() != USCC_LEN) {
            return false;
        }
        usccCode = usccCode.toUpperCase();
        //用于计算当前判断的统一社会信用代码位数
        int index = 0;
        //用于存放当前位的统一社会信用代码
        char testc;
        //用于存放代码字符和加权因子乘积之和
        int tempSum = 0;
        int tempNum;
        for (index = 0; index <= 16; index++) {
            testc = usccCode.charAt(index);
            if (index == 0) {
                if (testc != '1' && testc != '5' && testc != '9' && testc != 'Y') {
                    //System.out.println("统一社会信用代码中登记管理部门代码错误");
                    return false;
                }
            }
            if (index == 1) {
                if (testc != '1' && testc != '2' && testc != '3' && testc != '9') {
                    //System.out.println("统一社会信用代码中机构类别代码错误");
                    return false;
                }
            }
            tempNum = charToNum(testc);
            //验证代码中是否有错误字符
            if (tempNum != -1) {
                tempSum += WEIGHT[index] * tempNum;
            } else {
                //System.out.println("统一社会信用代码中出现错误字符");
                return false;
            }
        }
        tempNum = 31 - tempSum % 31;
        if (tempNum == 31) {
            tempNum = 0;
        }
        //按照GB/T 17710标准对统一社会信用代码前17位计算校验码，并与第18位校验位进行比对
        return charToNum(usccCode.charAt(17)) == tempNum;
    }

    //按照GB32100-2015标准代码字符集将用于检验的字符变为相应数字
    private static int charToNum(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            case 'G':
                return 16;
            case 'H':
                return 17;
            case 'J':
                return 18;
            case 'K':
                return 19;
            case 'L':
                return 20;
            case 'M':
                return 21;
            case 'N':
                return 22;
            case 'P':
                return 23;
            case 'Q':
                return 24;
            case 'R':
                return 25;
            case 'T':
                return 26;
            case 'U':
                return 27;
            case 'W':
                return 28;
            case 'X':
                return 29;
            case 'Y':
                return 30;
            default:
                return -1;
        }
    }
    
}
