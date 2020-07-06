export class DateUtils {

  /**
   * 获得当前学期
   *
   * @author suwen
   * @date 2020/6/29 上午11:00
   */
  static nowTerm() {
    const Dates = new Date();
    const year1: number = Dates.getFullYear();
    let term: number;
    let year2: number;
    if (Dates.getMonth() > 9) {
      year2 = year1 + 1;
      term = 1;
      return year2 + '/' + year1 + '(' + term + ')';
    } else {
      year2 = year1 - 1;
      term = 2;
      return year2 + '/' + year1 + '(' + term + ')';
    }
  };

}

