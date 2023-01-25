using System.ComponentModel.DataAnnotations;

namespace Models.TokenVerification;

public class TokenVerificationWithAccountCharge
{
    [Required]
    [Display(Name = "id")]
    public int id { get; set; }
    [Required]
    [Display(Name = "token")]
    public string? token { get; set; }
    [Required(ErrorMessage = "Charge ammount is required.")]
    [Display(Name = "value")]
    [Range(1, 1000000, ErrorMessage = "The charge must be greater than 1 and lower than 1000000.")]
    public int value { get; set; }
}