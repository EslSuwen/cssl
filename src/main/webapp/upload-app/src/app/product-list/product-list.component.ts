import { Component, OnInit } from '@angular/core';
import {FileUploader} from 'ng2-file-upload';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  private uploader: FileUploader = new FileUploader({
    url: '/devProject/uploadClient',
    method: 'POST',
    itemAlias: 'file'
  });

  constructor() { }

  ngOnInit() {
  }

  /**
   * 上传文件内容变化时执行的方法
   * @param event
   */
  selectedFileOnChanged(event: any) {
    // 这里是文件选择完成后的操作处理
    // alert('上传文件改变啦');
    console.log(event.target.value);
    console.log(event);
  }

  /**
   * 上传文件方法
   */
  uploadFile() {
    alert('执行上传文件');
    // 上传
    this.uploader.queue[0].onSuccess = function (response, status, headers) {
      // 上传文件成功
      if (status == 200) {
        // 上传文件后获取服务器返回的数据
        const tempRes = response;
        alert(response);
      } else {
        // 上传文件后获取服务器返回的数据错误
        alert('上传失败');
      }
    };
    // onSuccessItem(item: FileItem, response: string, status: number, headers: ParsedResponseHeaders): any;
    this.uploader.queue[0].upload(); // 开始上传
    // this.uploader.queue[0].onSuccess()
    alert('上传之后');
  }
}
