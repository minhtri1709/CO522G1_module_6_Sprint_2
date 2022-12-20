import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {TokenStorageService} from '../../service/token-storage.service';
import {AuthServiceService} from '../../service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formSign: FormGroup;
  formSignup: FormGroup;
  username: string;
  roles: string[] = [];
  returnUrl: string;
  constructor(
    private fb: FormBuilder,
    private ref: ChangeDetectorRef,
    private tokenStorageService: TokenStorageService,
    private authService: AuthServiceService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    window.scroll(0, 0);
    this.returnUrl = this.route.snapshot.queryParams.returnUrl || '';
    this.formSign = this.fb.group({
      username: [''],
      password: [''],
    });

    this.formSignup = this.fb.group({
      username: [''],
      formConfirm: new FormGroup({
        password: new FormControl(),
        confirmPassword: new FormControl(),
      }),
    });

    if (this.tokenStorageService.getToken()) {
      const user = this.tokenStorageService.getUser();
      this.authService.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      this.username = this.tokenStorageService.getUser().username;
    }
  }

  submit() {
    this.authService.login(this.formSign.value).subscribe((data) => {
      console.log(data);
      this.tokenStorageService.saveTokenSession(data.accessToken);
      this.tokenStorageService.saveUserLocal(data);
      // this.tokenStorageService.saveUserLocal(data);
      this.authService.isLoggedIn = true;
      this.username = this.tokenStorageService.getUser().username;
      this.roles = this.tokenStorageService.getUser().roles;
      this.formSign.reset();
    /*    Swal.fire({
          position: 'center',
          icon: 'success',
          title: this.username + ' Đăng nhập thành công !',
          showConfirmButton: false,
          timer: 2000
        });

        this.router.navigateByUrl('/index');
      },
      err => {
        this.authService.isLoggedIn = false;
        Swal.fire({
          position: 'center',
          icon: 'warning',
          title: 'Người dùng/ mật khẩu không hợp lệ. Vui lòng thử lại!',
          showConfirmButton: false,
          timer: 2000
        });
      }
    );*/
      window.location.replace('');
    });
  }

  exit() {
    this.router.navigateByUrl('');
  }

  logOut(): void {
    // this.authSocialService.signOut().then(
    //   data => {
    this.tokenStorageService.logOut();
    this.router.navigateByUrl('');
    //   }
    // );
  }
  register() {}
}
