import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
  { path: '/doctor-owner/dashboard', title: 'Accueil', icon: 'fas fa-home', class: '' },
  { path: '/doctor-owner/customer_history', title: 'Clients', icon: 'fas fa-users', class: '' },
  { path: '/doctor-owner/staff', title: 'Personnel', icon: 'fas fa-users', class: '' },
  { path: '/doctor-owner/statistic', title: 'Statistic',  icon: 'fas fa-chart-bar', class: '' },
  { path: '/doctor-owner/bank-transactions', title: 'Compte bancaire', icon: 'fas fa-piggy-bank', class: '' },
  { path: '/doctor-owner/profile', title: 'Profile', icon: 'fas fa-id-badge', class: '' }
];


@Component({
  selector: 'app-sidebar',
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
