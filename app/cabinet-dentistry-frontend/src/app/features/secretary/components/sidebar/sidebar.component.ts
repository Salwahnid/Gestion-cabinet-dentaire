import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
  { path: '/secretary/dashboard', title: 'Accueil', icon: 'fas fa-home', class: '' },
  { path: '/secretary/customer_history', title: 'Clients', icon: 'fas fa-users', class: '' },
  { path: '/secretary/profile', title: 'Profile', icon: 'fas fa-id-badge', class: '' }
];


@Component({
  selector: 'sec-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  public menuItems: any[];
  public isCollapsed = true;

  constructor(private router: Router) { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
    this.router.events.subscribe((event) => {
      this.isCollapsed = true;
   });
  }
}
