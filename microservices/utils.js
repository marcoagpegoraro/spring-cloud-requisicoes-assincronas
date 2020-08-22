module.exports = {
  sleepOneSecond() {
    let seconds = 1.5;
    let e = new Date().getTime() + (seconds * 1000);
    while (new Date().getTime() <= e) { }
  }
}