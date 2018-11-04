package com.movetogbg;

public class Account {

    private static String UserName;
    private static String UserAge;

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static String getUserAge() {
        return UserAge;
    }

    public static void setUserAge(String userAge) {
        UserAge = userAge;
    }

    public static String getUserGender() {
        return UserGender;
    }

    public static void setUserGender(String userGender) {
        UserGender = userGender;
    }

    private static String UserGender;

   private static boolean accountCreated = false;

    public static boolean isAccountCreated() {
        return accountCreated;
    }

    public static void setAccountCreated(boolean accountCreated) {
        Account.accountCreated = accountCreated;
    }


}
