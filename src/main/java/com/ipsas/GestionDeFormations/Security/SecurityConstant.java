package com.ipsas.GestionDeFormations.Security;

public class SecurityConstant {
    public static final long Expiration_Time = 604_800_000;
    public static final String Token_Prefix = "Bearer ";
    public static final String JWT_Token_Header = "Jwt-Token";
    public static final String Token_Cannot_Be_Verified = "Token Cannot be verified !";
    public static final String Get_Arrays_LLC = "Get Arrays, LLC";
    public static final String Get_Arrays_Administration = "User Management";
    public static final String Authorities = "Authorities";
    public static final String Forbidden_Message = "You need to log in to get access to this page !";
    public static final String Access_Denied_Message = "You do not have Permissions to access this page !";
    public static final String Options_Http_Method = "OPTIONS";
    public static final String[] Public_Urls = {"/user/login","/user/register","/user/resetpassword/**","/user/image/**"} ;
}
