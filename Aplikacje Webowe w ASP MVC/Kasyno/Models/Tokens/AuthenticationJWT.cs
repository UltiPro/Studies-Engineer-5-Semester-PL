#pragma warning disable CS8618

namespace AuthenticationJWT;

public class AuthenticationJwtSettings
{
    public string JwtKey { get; set; }
    public int JwtExpireDays { get; set; }
    public string JwtIssuer { get; set; }
}