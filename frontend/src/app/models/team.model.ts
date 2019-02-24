export class Team {
  id: number;
  name: string;
  budget: number;

  constructor(name: string, budget: number) {
    this.name = name;
    this.budget = budget;
  }
}
