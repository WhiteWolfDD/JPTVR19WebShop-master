
package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Buyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private Double money;
    @Column(unique = true)
    private String email;
    private String town;
    private String phoneNumber;
    private String buyerDescription;
    private String birthDate;
    private String employee;
    private String employeeCompany;
    private String address;
    private String userWebsite;
    private String userGithub;
    private String userTwitter;
    private String userInstagram;
    private String userFacebook;
    private String userVk;
    private String userTelegram;
    @OneToOne
    private Avatar avatar;

    public Buyer() {
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", money=" + money +
                ", email='" + email + '\'' +
                ", town='" + town + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", buyerDescription='" + buyerDescription + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", employee='" + employee + '\'' +
                ", employeeCompany='" + employeeCompany + '\'' +
                ", address='" + address + '\'' +
                ", userWebsite='" + userWebsite + '\'' +
                ", userGithub='" + userGithub + '\'' +
                ", userTwitter='" + userTwitter + '\'' +
                ", userInstagram='" + userInstagram + '\'' +
                ", userFacebook='" + userFacebook + '\'' +
                ", userVk='" + userVk + '\'' +
                ", userTelegram='" + userTelegram + '\'' +
                ", avatar=" + avatar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(id, buyer.id) && Objects.equals(name, buyer.name) && Objects.equals(lastname, buyer.lastname) && Objects.equals(money, buyer.money) && Objects.equals(email, buyer.email) && Objects.equals(town, buyer.town) && Objects.equals(phoneNumber, buyer.phoneNumber) && Objects.equals(buyerDescription, buyer.buyerDescription) && Objects.equals(birthDate, buyer.birthDate) && Objects.equals(employee, buyer.employee) && Objects.equals(employeeCompany, buyer.employeeCompany) && Objects.equals(address, buyer.address) && Objects.equals(userWebsite, buyer.userWebsite) && Objects.equals(userGithub, buyer.userGithub) && Objects.equals(userTwitter, buyer.userTwitter) && Objects.equals(userInstagram, buyer.userInstagram) && Objects.equals(userFacebook, buyer.userFacebook) && Objects.equals(userVk, buyer.userVk) && Objects.equals(userTelegram, buyer.userTelegram) && Objects.equals(avatar, buyer.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, money, email, town, phoneNumber, buyerDescription, birthDate, employee, employeeCompany, address, userWebsite, userGithub, userTwitter, userInstagram, userFacebook, userVk, userTelegram, avatar);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBuyerDescription() {
        return buyerDescription;
    }

    public void setBuyerDescription(String buyerDescription) {
        this.buyerDescription = buyerDescription;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getEmployeeCompany() {
        return employeeCompany;
    }

    public void setEmployeeCompany(String employeeCompany) {
        this.employeeCompany = employeeCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserWebsite() {
        return userWebsite;
    }

    public void setUserWebsite(String userWebsite) {
        this.userWebsite = userWebsite;
    }

    public String getUserGithub() {
        return userGithub;
    }

    public void setUserGithub(String userGithub) {
        this.userGithub = userGithub;
    }

    public String getUserTwitter() {
        return userTwitter;
    }

    public void setUserTwitter(String userTwitter) {
        this.userTwitter = userTwitter;
    }

    public String getUserInstagram() {
        return userInstagram;
    }

    public void setUserInstagram(String userInstagram) {
        this.userInstagram = userInstagram;
    }

    public String getUserFacebook() {
        return userFacebook;
    }

    public void setUserFacebook(String userFacebook) {
        this.userFacebook = userFacebook;
    }

    public String getUserVk() {
        return userVk;
    }

    public void setUserVk(String userVk) {
        this.userVk = userVk;
    }

    public String getUserTelegram() {
        return userTelegram;
    }

    public void setUserTelegram(String userTelegram) {
        this.userTelegram = userTelegram;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Buyer(String name, String lastname, Double money, String email, String town, String phoneNumber, String buyerDescription, String birthDate, String employee, String employeeCompany, String address, String userWebsite, String userGithub, String userTwitter, String userInstagram, String userFacebook, String userVk, String userTelegram, Avatar avatar) {
        this.name = name;
        this.lastname = lastname;
        this.money = money;
        this.email = email;
        this.town = town;
        this.phoneNumber = phoneNumber;
        this.buyerDescription = buyerDescription;
        this.birthDate = birthDate;
        this.employee = employee;
        this.employeeCompany = employeeCompany;
        this.address = address;
        this.userWebsite = userWebsite;
        this.userGithub = userGithub;
        this.userTwitter = userTwitter;
        this.userInstagram = userInstagram;
        this.userFacebook = userFacebook;
        this.userVk = userVk;
        this.userTelegram = userTelegram;
        this.avatar = avatar;
    }
}
    