if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'js'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'js'.");
}
var js = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main() {
    println('Hello World');
  }
  _.main = main;
  main();
  Kotlin.defineModule('js', _);
  return _;
}(typeof js === 'undefined' ? {} : js, kotlin);
