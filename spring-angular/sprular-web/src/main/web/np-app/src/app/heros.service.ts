import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Hero} from "./Hero";

@Injectable()
export class HeroService {
  constructor(private http: HttpClient) {
  }

  configUrl = 'http://localhost:8090/api/heroes';

  getHeroes() {
    return this.http.get(this.configUrl);
  }
}
