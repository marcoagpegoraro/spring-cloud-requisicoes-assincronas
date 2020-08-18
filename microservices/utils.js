module.exports = {
  sleep() {
    let seconds = 1;
    let e = new Date().getTime() + (seconds * 1000);
    while (new Date().getTime() <= e) { }
  }
}