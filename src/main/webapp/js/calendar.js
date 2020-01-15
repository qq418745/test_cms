$(function() {
	var Calendar = function(element, option) {
		this.option = option;
		this.element = element;
		var date = new Date();
		this.year = date.getFullYear();
		this.month = date.getMonth();
		this.day = date.getDate();
		this.hour = date.getHours();
		this.minute = date.getMinutes();
		this.second = date.getSeconds();

		this.init();
	};
	Calendar.prototype = {
		init: function() {
			this.creat();
			this.creatDates();
			this.creatHeader();
			this.clickDates();
			this.nextMonth();
			this.preMonth();
			this.showCalendar();
			this.showOnInput();
			this.selectDay();
			if (this.option.button) {
				this.buttons();
				this.confirm();
				this.cancel();
			} else {
			}
			if (this.option.time) {
				this.time();
				this.creatTime();
				this.showTime();
				this.timeChoose();
			}
		},
		creat: function() {
			var weekArr = ['日', '一', '二', '三', '四', '五', '六'];
			var week = '';
			for (var i = 0; i < weekArr.length; i++) {
				week += '<p>' + weekArr[i] + '</p>';
			}
			var html =
				'<div class="calendar">' +
				'<div class="calendar-header">' +
				'<p></p>' +
				'<i class="fa fa-angle-left calendar-pre"></i>' +
				'<i class="fa fa-angle-right calendar-next"></i>' +
				'</div>' +
				'<div class="clendar-main">' +
				' <div class="calendar-week">' +
				week +
				'</div>' +
				'<ul class="calendar-days"></ul>' +
				'</div>' +
				'<div class="calendar-bottom"><div class="time-show"></div><div class="calendar-button"></div></div>' +
				'</div>';
			$(this.element).append(html);
		},
		creatHeader: function() {
			var header = this.year + '-' + (this.month + 1 < 10 ? '0' + (this.month + 1) : this.month + 1) + '-' + this.day;
			$('.calendar-header p').text(header);
		},
		creatDates: function() {
			$('.calendar-days').empty();
			var dates = '';
			var lastMonthWeekDay = new Date(this.year, this.month, 0).getDay(); //上月最后一天是周几
			var lastMonthDay = new Date(this.year, this.month, 0).getDate(); //上个月有多少天
			var currentMonthDay = new Date(this.year, this.month + 1, 0).getDate(); //本月有多少天
			var currentMonthWeekDay = new Date(this.year, this.month + 1, 0).getDay(); //本月最后一天星期几

			if (lastMonthWeekDay != 6) {
				for (var i = 0; i <= lastMonthWeekDay; i++) {
					dates += '<li><p class="date-default">' + (lastMonthDay - lastMonthWeekDay + i) + '</p></li>';
				}
			}
			for (var i = 0; i < currentMonthDay; i++) {
				if (i + 1 == this.day) {
					dates += '<li class="date active"><p>' + (i + 1) + '</p></li>';
				} else {
					dates += '<li class="date"><p>' + (i + 1) + '</p></li>';
				}
			}
			// 当前展示面板上下个月展示几天
			if (currentMonthWeekDay != 6) {
				var nextMonth = 6 - currentMonthWeekDay;
				for (var i = 0; i < nextMonth; i++) {
					dates += '<li><p class="date-default">' + (i + 1) + '</p></li>';
				}
			}
			$('.calendar-days').append(dates);
		},
		clickDates: function() {
			this.element.on('click', '.date', function() {
				if ($('.active').length > 0) {
					$('.active').removeClass('active');
					$(this).addClass('active');
				} else {
					$(this).addClass('active');
				}
			});
		},
		nextMonth: function() {
			var self = this;
			this.element.on('click', '.fa-angle-right', function(e) {
				e.stopPropagation();
				if (self.month < 11) {
					self.month++;
				} else {
					self.year++;
					self.month = 0;
				}
				self.creatHeader();
				self.creatDates();
			});
		},
		preMonth: function() {
			var self = this;
			this.element.on('click', '.fa-angle-left', function(e) {
				e.stopPropagation();
				if (self.month > 0) {
					self.month--;
				} else {
					self.year--;
					self.month = 11;
				}
				self.creatHeader();
				self.creatDates();
			});
		},
		selectDay: function() {
			var self = this;
			this.element.on('click', '.date', function(e) {
				e.stopPropagation();
				self.day = $(this).text();
				self.creatHeader();
				if (!self.option.button) {
					self.showOnInput();
				}
			});
		},
		showCalendar: function() {
			this.element.on('click', 'input', function() {
				$('.calendar').toggle();
			});
		},
		time: function() {
			$('.time-show').empty();
			var time =
				'<p class="time">' +
				(this.hour < 10 ? '0' + this.hour : this.hour) +
				':' +
				(this.minute < 10 ? '0' + this.minute : this.minute) +
				':' +
				(this.second < 10 ? '0' + this.second : this.second) +
				'</p>';
			$('.time-show').append(time);
		},
		creatTime: function() {
			var time = '',
				hours = '',
				minutes = '',
				seconds = '';
			for (var i = 0; i < 12; i++) {
				if (i == this.hour) {
					hours += '<li class="active" type="hour" hour="' + i + '">' + (i < 10 ? '0' + i : i) + '</li>';
				} else {
					hours += '<li type="hour" hour="' + i + '">' + (i < 10 ? '0' + i : i) + '</li>';
				}
			}
			for (j = 0; j < 60; j++) {
				if (j == this.minute) {
					minutes += '<li class="active" type="minute" minute="' + j + '">' + (j < 10 ? '0' + j : j) + '</li>';
					seconds += '<li class="active" type="second" second="' + j + '">' + (j < 10 ? '0' + j : j) + '</li>';
				} else {
					minutes += '<li type="minute" minute="' + j + '">' + (j < 10 ? '0' + j : j) + '</li>';
					seconds += '<li type="second" second="' + j + '">' + (j < 10 ? '0' + j : j) + '</li>';
				}
			}
			time =
				'<div class="calendar-time">' +
				'<ul class="time-hour">' +
				hours +
				'</ul>' +
				'<ul class="time-mintes">' +
				minutes +
				'</ul>' +
				'<ul class="time-seconds">' +
				seconds +
				'</ul>' +
				'</div>';
			$('.clendar-main').append(time);
		},
		showTime: function() {
			this.element.on('click', '.time', function(e) {
				e.stopPropagation();
				$('.calendar-time').toggle();
			});
			this.element.on('click', '.calendar-time', function(e) {
				e.stopPropagation();
			});
		},
		timeChoose: function() {
			var self = this;
			this.element.on('click', '.calendar-time li', function(e) {
				e.stopPropagation();
				$(this)
					.siblings()
					.removeClass('active');
				$(this).addClass('active');
				var type = $(this).attr('type');
				switch (type) {
					case 'hour':
						self.hour = $(this).attr('hour');
						break;
					case 'minute':
						self.minute = $(this).attr('minute');
						break;
					case 'second':
						self.second = $(this).attr('second');
						break;
				}
				self.time();
				if (!self.option.button) {
					self.showOnInput();
				}
			});
		},
		showOnInput: function() {
			var valueTime = '';
			if (this.option.time) {
				valueTime = (this.hour < 10 ? '0' + this.hour : this.hour) + ':' + (this.minute < 10 ? '0' + this.minute : this.minute) + ':' + (this.second < 10 ? '0' + this.second : this.second);
			}

			var value = this.year + '-' + (this.month + 1 < 10 ? '0' + (this.month + 1) : this.month) + '-' + (this.day < 10 ? '0' + this.day : this.day) + ' ' + valueTime;

			this.element.find('input').val(value.trim());
		},
		buttons: function() {
			var buttons = '<button class="calendar-confirm" type="button">确定</button><button class="calendar-cancel" type="button">取消</button>';
			$('.calendar-button').append(buttons);
		},
		confirm: function() {
			var self = this;
			$('.calendar-confirm').on('click', function() {
				var value = $('.calendar-header p').text() + ' ' + $('.time').text();
				self.element.find('input').val(value);
				$('.calendar').hide();
			});
		},
		cancel: function() {
			$('.calendar-cancel').on('click', function() {
				$('.calendar').hide();
			});
		}
	};

	$.fn.calendar = function(option) {
		var defaultOptions = {
			button: true,
			time: true
		};
		new Calendar(this, $.extend(defaultOptions, option));
	};
});
