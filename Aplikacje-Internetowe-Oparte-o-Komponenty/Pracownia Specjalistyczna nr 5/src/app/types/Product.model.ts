export class Product {
  constructor(
    private carbohydrates: number,
    private fat: number,
    private kcal: number,
    private name: string,
    private protein: number
  ) {}

  get Name(): string {
    return this.name;
  }
  set Name(newName: string) {
    this.name = newName;
  }
  get Kcal(): number {
    return this.kcal;
  }
  set Kcal(newKcal: number) {
    this.kcal = newKcal;
  }
  get Fat(): number {
    return this.fat;
  }
  set Fat(newFat: number) {
    this.fat = newFat;
  }
  get Carbohydrates(): number {
    return this.carbohydrates;
  }
  set Carbohydrates(newCarbohydrates: number) {
    this.carbohydrates = newCarbohydrates;
  }
  get Protein(): number {
    return this.protein;
  }
  set Protein(newProtein: number) {
    this.protein = newProtein;
  }
}
export interface PostProduct {
  carbohydrates: number;
  fat: number;
  kcal: number;
  name: string;
  protein: number;
  id?:string;
}
