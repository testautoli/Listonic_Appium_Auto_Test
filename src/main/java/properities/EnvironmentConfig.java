package properities;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:global.properties")
public interface EnvironmentConfig extends Config {

    @Key("DEVICE_NAME")
    String deviceName();

    @Key("AUTOMATION_NAME")
    String automationName();

    @Key("APK_NAME")
    String getApp();

    @Key("PASSWORD")
    String getPassword();

    @Key("CORRECT_EMAIL")
    String getCorrectEmail();

    @Key("CORRECT_EMAIL_BY_GOOGLE")
    String getCorrectEmailByGoogle();

    @Key("CORRECT_REGISTER_USER_EMAIL")
    String getCorrectRegisterUserEmail();

    @Key("CORRECT_PASSWORD_REGISTER_USER")
    String getCorrectPasswordRegisterUser();

    @Key("NAME_OF_LIST_CREATED_BY_UNREGISTERED_USER")
    String getNameOfListCreatedByUnregisteredUser();

    @Key("NAME_OF_LIST_CREATED_BY_REGISTERED_USER")
    String getNameOfListCreatedByRegisteredUser();

    @Key("EMAIL_FOR_CHANGING")
    String getEmailForChange();

    @Key("PASSWORD_FOR_EMAIL_CHANGE")
    String getPasswordForEmailChange();

    @Key("EMAIL_CHANGED")
    String getEmailToChange();

    @Key("PASSWORD_CHANGED")
    String getPasswordToChange();
}
