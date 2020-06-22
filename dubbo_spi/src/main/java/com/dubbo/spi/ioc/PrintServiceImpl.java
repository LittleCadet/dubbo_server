package com.dubbo.spi.ioc;

/**
 * @author shenxie
 * @date 2020/6/14
 */
public class PrintServiceImpl implements PrintServiceFacade{

    private PrintServiceBean printServiceBean;

    public PrintServiceBean getPrintServiceV1() {
        return printServiceBean;
    }

    public void setPrintServiceV1(PrintServiceBean printServiceV1) {
        this.printServiceBean = printServiceV1;
    }

    @Override
    public String showInfo() {
        return printServiceBean.toString();
    }
}
