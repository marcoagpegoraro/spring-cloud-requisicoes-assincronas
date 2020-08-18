module.exports = {
  sleep() {
    let seconds = 3;
    let e = new Date().getTime() + (seconds * 1000);
    while (new Date().getTime() <= e) { }
  }
}