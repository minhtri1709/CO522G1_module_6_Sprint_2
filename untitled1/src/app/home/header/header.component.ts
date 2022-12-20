import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../../service/token-storage.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username = '';
  roles: string[] ;
  isCustomer = false;
  isAdmin = false;

  constructor(private tokenStorageService: TokenStorageService,
              private router: Router) {

  }

  ngOnInit(): void {

    this.showUsername();
  }

  showUsername() {
    this.username = this.tokenStorageService.getUser().username;
    console.log(this.username);
    this.roles = this.tokenStorageService.getUser().roles;
    this.isCustomer = this.roles.indexOf('ROLE_USER') !== -1;
    this.isAdmin = this.roles.indexOf('ROLE_ADMIN') !== -1;
  }

  whenLogout() {
    Swal.fire({
      position: 'center',
      icon: 'success',
      title: ' Đăng xuất thành công !',
      showConfirmButton: false,
      timer: 1000
    });
    this.tokenStorageService.logOut();
    this.router.navigateByUrl('');
    this.username = '';
    this.isCustomer = false;
    this.isAdmin = false;
  }

}
