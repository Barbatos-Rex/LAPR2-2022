package app.domain.model;

import java.util.Objects;

public class SNSUser {
    private final String socialId;
    private final String firstName;

    private final String middleNames;
    private final String lastName;
    private final String identificationNumber;

    private final String email;

    private final String phoneNumber;

    public SNSUser(String socialId, String firstName, String middleNames, String lastName, String identificationNumber, String email, String phoneNumber) {
        this.socialId = socialId;
        this.firstName = firstName;
        this.middleNames = middleNames;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SNSUser snsUser = (SNSUser) o;
        return Objects.equals(socialId, snsUser.socialId) && Objects.equals(identificationNumber, snsUser.identificationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialId, identificationNumber);
    }

    @Override
    public String toString() {
        return "SNSUser{" +
                "socialId='" + socialId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleNames='" + middleNames + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
