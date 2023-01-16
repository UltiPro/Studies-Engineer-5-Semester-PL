#pragma warning disable CS8618

using System.ComponentModel.DataAnnotations;

namespace Models.Roulette;

public class RouletteColorRequest
{
    [Required]
    [Display(Name = "id")]
    public int id { get; set; }
    [Required]
    [Display(Name = "token")]
    public string? token { get; set; }
    [Required]
    [Display(Name = "decision")]
    public string decision { get; set; }
    [Required]
    [Display(Name = "betMoney")]
    public int betMoney { get; set; }
}