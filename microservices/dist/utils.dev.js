"use strict";

module.exports = {
  sleepOneSecond: function sleepOneSecond() {
    var seconds = 1.5;
    var e = new Date().getTime() + seconds * 1000;

    while (new Date().getTime() <= e) {}
  }
};