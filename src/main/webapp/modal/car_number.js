function CarNumber(v) {
    this.templateUrl = 'carProvinceAndCity.html';
    this.provinces = ["苏", "皖", "沪", "京", "津", "冀", "豫", "云", "辽", "黑", "湘", "鲁", "新", "浙", "赣", "鄂", "桂", "甘", "晋", "蒙", "陕", "吉", "闽", "贵", "粤", "川", "青", "藏", "琼", "宁", "渝"];
    this.cities = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];

    this.carProvince = this.provinces[0];
    this.carCity = this.cities[0];
    this.carNum = '';

    this.getCarNumber = function() {
        return this.carProvince + this.carCity + this.carNum;
    };
    this.parse = function(v){
        if (!v){
            return;
        }
        this.carProvince = v.substring(0, 1);
        if (!this.provinces.contains(this.carProvince)){
            this.carProvince = this.provinces[0];
        }
        this.carCity = v.substring(1, 2);
        if (!this.cities.contains(this.carCity)){
            this.carCity = this.cities[0];
        }
        this.carNum = v.substring(2);
    };

    this.parse(v);

    this.current = 0;
    this.items = function () {
        return this.current === 0 ? this.provinces : this.cities;
    };

    this.choose = function (index) {
        if (this.current === 0) {
            this.carProvince = this.provinces[index];
            this.current = 1;
        } else {
            this.carCity = this.cities[index];
            this.current = 0;
        }
    };
}
