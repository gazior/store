package pl.com.szymanski.store.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

public class Payu {


    //private String extOrderId;

    private String notifyUrl;
    private String customerIp;
    private String merchantPosId;
    private String description;
    private String currencyCode;
    private String totalAmount;

    private String continueUrl;
    private Buyer buyer;

    public String getContinueUrl() {
        return continueUrl;
    }

    public void setContinueUrl(String continueUrl) {
        this.continueUrl = continueUrl;
    }

    private List<Product1> products;

    public Payu(){

    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public String getMerchantPosId() {
        return merchantPosId;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public List<Product1> getProducts() {
        return products;
    }

//    public String getExtOrderId() {
//        return extOrderId;
//    }
//
//    public void setExtOrderId(String extOrderId) {
//        this.extOrderId = extOrderId;
//    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public void setMerchantPosId(String merchantPosId) {
        this.merchantPosId = merchantPosId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setProducts(List<Product1> products) {
        this.products = products;
    }


}
