package info.hccis.parkingPass.model.jpa;

import java.io.Serializable;

/**
 * This is customer class to hold all the customer attributes
 *
 * @author mrahman2
 * @since Dec 01, 2020
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer customerTypeId;
    private String fullName;
    private String address1;
    private String city;
    private String province;
    private String postalCode;
    private String phoneNumber;
    private String birthDate;
    private String loyaltyCard;
    private String customerTypeDescription;

    /**
     * Public constructor
     *
     * @author mrahman2
     * @since Dec 01, 2020
     */
    public Customer() {
    }

    /**
     * Custom constructor
     *
     * @author mrahman2
     * @since Dec 01, 2020
     */
    public Customer(Integer id) {
        this.id = id;
    }

    /**
     * Custom constructor
     *
     * @author mrahman2
     * @since Dec 01, 2020
     */
    public Customer(Integer id, Integer customerTypeId, String fullName, String address1, String city, String province, String postalCode, String phoneNumber, String birthDate, String loyaltyCard, String customerTypeDescription) {
        this.id = id;
        this.customerTypeId = customerTypeId;
        this.fullName = fullName;
        this.address1 = address1;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.loyaltyCard = loyaltyCard;
        this.customerTypeDescription = customerTypeDescription;
    }

    public String getCustomerTypeDescription() {
        return customerTypeDescription;
    }

    public void setCustomerTypeDescription(String customerTypeDescription) {
        this.customerTypeDescription = customerTypeDescription;
    }

    public Customer(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(String loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer Details : \n" + "Customer ID : " + id + "\nType ID : " + customerTypeId
                + "\nName : " + fullName + "\nAddress : " + address1 + "\nCity : " + city
                + "\nProvince : " + province + "\nPostal Code : " + postalCode + "\nPhone Number : "
                + phoneNumber + "\nBirthday : " + birthDate + "\nLoyalty Card # : " + loyaltyCard;
    }
}
