package com.egencia.dynamic.springconfig.model;

public class AmadeusAuthConfigItem {

    private String sourceOfficeID;
    private String organizationID;
    private String originator;
    private String password;
    private Integer passwordLength;

    private AmadeusAuthConfigItem() {
    }

    public AmadeusAuthConfigItem(String sourceOfficeID, String organizationID, String originator, String password, Integer passwordLength) {
        this.sourceOfficeID = sourceOfficeID;
        this.organizationID = organizationID;
        this.originator = originator;
        this.password = password;
        this.passwordLength = passwordLength;
    }

    public String getSourceOfficeID() {
        return sourceOfficeID;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public String getOriginator() {
        return originator;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPasswordLength() {
        return passwordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AmadeusAuthConfigItem that = (AmadeusAuthConfigItem) o;

        if (!organizationID.equals(that.organizationID)) return false;
        if (!originator.equals(that.originator)) return false;
        if (!password.equals(that.password)) return false;
        if (!passwordLength.equals(that.passwordLength)) return false;
        if (!sourceOfficeID.equals(that.sourceOfficeID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sourceOfficeID.hashCode();
        result = 31 * result + organizationID.hashCode();
        result = 31 * result + originator.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + passwordLength.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AmadeusAuthConfigItem{" +
                "sourceOfficeID='" + sourceOfficeID + '\'' +
                ", organizationID='" + organizationID + '\'' +
                ", originator='" + originator + '\'' +
                ", password='" + password + '\'' +
                ", passwordLength=" + passwordLength +
                '}';
    }
}
