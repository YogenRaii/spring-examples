import {Component} from '@angular/core';
import {Hero} from "./Hero";
import {HeroService} from "./heros.service";

@Component({
  selector: 'app-root',
  template: `
    <!--The content below is only a placeholder and can be replaced.-->
    <div style="text-align:center">
      <h1>
        Welcome to {{title}}!
      </h1>
    </div>
    <h2>Here are Heros: </h2>
    <ul>
      <li *ngFor="let hero of heroes">
        <h2>{{hero.name}}</h2>
        <h2>{{hero.rating}}</h2>
      </li>
    </ul>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Sprular App';

  heroes: Hero[];

  constructor(private heroService: HeroService) {}

  ngOnInit() {
    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService.getHeroes().subscribe((heroes: Hero[]) => {
      this.heroes = heroes;
      console.log(this.heroes);
    });
  }
}
