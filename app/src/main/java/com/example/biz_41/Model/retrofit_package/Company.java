
package com.example.biz_41.Model.retrofit_package;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Company extends RealmObject {

    @PrimaryKey
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("description")
    @Expose
    private String description;
    @Ignore
    @SerializedName("emails")
    @Expose
    private List<String> emails;
    @SerializedName("phones")
    @Expose
    private String phones;
    @SerializedName("postAddress")
    @Expose
    private String postAddress;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("faxes")
    @Expose
    private String faxes;
    @Ignore
    @SerializedName("contactPeople")
    @Expose
    private ContactPeople contactPeople;
    @Ignore
    @SerializedName("openHours")
    @Expose
    private OpenHours openHours;
    @SerializedName("skype")
    @Expose
    private String skype;
    @SerializedName("employeesNumber")
    @Expose
    private Integer employeesNumber;
    @SerializedName("yearOfFoundation")
    @Expose
    private String yearOfFoundation;
    @SerializedName("regionName")
    @Expose
    private String regionName;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
@Ignore
    @SerializedName("bankDetails")
    @Expose
    private BankDetails bankDetails;
    @SerializedName("productsAndOffers")
    @Expose
    private String productsAndOffers;
    @Ignore
    @SerializedName("branches")
    @Expose
    private List<String> branches = null;
    @SerializedName("trademarks")
    @Expose
    private String trademarks;
    @Ignore
    @SerializedName("categoriesId")
    @Expose
    private List<String> categoriesId = null;
    @Ignore
    @SerializedName("companyRegionsId")
    @Expose
    private List<String> companyRegionsId = null;
    @Ignore
    @SerializedName("exportRegionsID")
    @Expose
    private List<String> exportRegionsID = null;
    @Ignore
    @SerializedName("importRegionsId")
    @Expose
    private List<String> importRegionsId = null;
    @SerializedName("qualityStandarts")
    @Expose
    private String qualityStandarts;
    @SerializedName("sitesUrl")
    @Expose
    private String sitesUrl;
    @Ignore
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getEmails() {
        return emails;
    }
    public String getEmail() {

        return emails.get(0);
    }
    public Company(Company company){
        this.id = company.getId();
        this.slug = company.getSlug();
        this.name = company.getName();
        this.description = company.getDescription();
        this.phones = company.getPhones();
        this.address = company.getAddress();
        this.skype = company.getSkype();
        this.regionName = company.getRegionName();
        this.productsAndOffers = company.getProductsAndOffers();
        this.categoriesId = company.getCategoriesId();
        this.companyRegionsId = company.getCompanyRegionsId();
        this.sitesUrl = company.getSitesUrl();
        this.rating = company.getRating();
        this.contactPeople = company.getContactPeople();
        this.yearOfFoundation = company.getYearOfFoundation();
        this.emails = company.getEmails();
    }
    public void setAll(Company company){
        this.id = company.getId();
        this.slug = company.getSlug();
        this.name = company.getName();
        this.description = company.getDescription();
        this.phones = company.getPhones();
        this.address = company.getAddress();
        this.skype = company.getSkype();
        this.regionName = company.getRegionName();
        this.productsAndOffers = company.getProductsAndOffers();
        this.categoriesId = company.getCategoriesId();
        this.companyRegionsId = company.getCompanyRegionsId();
        this.sitesUrl = company.getSitesUrl();
        this.rating = company.getRating();
        this.contactPeople = company.getContactPeople();
        this.yearOfFoundation = company.getYearOfFoundation();
        this.emails = company.getEmails();
    }
    public Company(String id, String slug, String name, String description, String phones, String address, String skype, String regionName, String productsAndOffers, List<String> categoriesId, List<String> companyRegionsId, String sitesUrl) {

        this.id = id;
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.phones = phones;
        this.address = address;
        this.skype = skype;
        this.regionName = regionName;
        this.productsAndOffers = productsAndOffers;
        this.categoriesId = categoriesId;
        this.companyRegionsId = companyRegionsId;
        this.sitesUrl = sitesUrl;
        this.rating = 3;
        this.contactPeople = new ContactPeople();

    }

    public Company(String id, String slug, String name, String logo, String description, List<String> emails, String phones, String postAddress, String address, String faxes, ContactPeople contactPeople, OpenHours openHours, String skype, Integer employeesNumber, String yearOfFoundation, String regionName, BankDetails bankDetails, String productsAndOffers, List<String> branches, String trademarks, List<String> categoriesId, List<String> companyRegionsId, List<String> exportRegionsID, List<String> importRegionsId, String qualityStandarts, String sitesUrl) {

        this.id = id;
        this.slug = slug;
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.emails = emails;
        this.phones = phones;
        this.postAddress = postAddress;
        this.address = address;
        this.faxes = faxes;
        this.contactPeople = contactPeople;
        this.openHours = openHours;
        this.skype = skype;
        this.employeesNumber = employeesNumber;
        this.yearOfFoundation = yearOfFoundation;
        this.regionName = regionName;
        this.bankDetails = bankDetails;
        this.productsAndOffers = productsAndOffers;
        this.branches = branches;
        this.trademarks = trademarks;
        this.categoriesId = categoriesId;
        this.companyRegionsId = companyRegionsId;
        this.exportRegionsID = exportRegionsID;
        this.importRegionsId = importRegionsId;
        this.qualityStandarts = qualityStandarts;
        this.sitesUrl = sitesUrl;
        this.rating = 3;
    }

    public Company() {
    this.rating = 3;
    }

    public void setEmail(String email) {
        emails = new ArrayList<>();
        emails.add(email);

    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFaxes() {
        return faxes;
    }

    public void setFaxes(String faxes) {
        this.faxes = faxes;
    }

    public ContactPeople getContactPeople() {
        return contactPeople;
    }

    public void setContactPeople(ContactPeople contactPeople) {
        this.contactPeople = contactPeople;
    }

    public OpenHours getOpenHours() {
        return openHours;
    }

    public void setOpenHours(OpenHours openHours) {
        this.openHours = openHours;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(String yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getProductsAndOffers() {
        return productsAndOffers;
    }

    public void setProductsAndOffers(String productsAndOffers) {
        this.productsAndOffers = productsAndOffers;
    }

    public List<String> getBranches() {
        return branches;
    }

    public void setBranches(List<String> branches) {
        this.branches = branches;
    }

    public String getTrademarks() {
        return trademarks;
    }

    public void setTrademarks(String trademarks) {
        this.trademarks = trademarks;
    }

    public List<String> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(List<String> categoriesId) {
        this.categoriesId = categoriesId;
    }

    public List<String> getCompanyRegionsId() {
        return companyRegionsId;
    }

    public void setCompanyRegionsId(List<String> companyRegionsId) {
        this.companyRegionsId = companyRegionsId;
    }

    public List<String> getExportRegionsID() {
        return exportRegionsID;
    }

    public void setExportRegionsID(List<String> exportRegionsID) {
        this.exportRegionsID = exportRegionsID;
    }

    public List<String> getImportRegionsId() {
        return importRegionsId;
    }

    public void setImportRegionsId(List<String> importRegionsId) {
        this.importRegionsId = importRegionsId;
    }

    public String getQualityStandarts() {
        return qualityStandarts;
    }

    public void setQualityStandarts(String qualityStandarts) {
        this.qualityStandarts = qualityStandarts;
    }

    public String getSitesUrl() {
        return sitesUrl;
    }

    public void setSitesUrl(String sitesUrl) {
        this.sitesUrl = sitesUrl;
    }

}
