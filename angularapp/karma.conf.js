// Karma configuration file, see link for more information
// https://karma-runner.github.io/1.0/config/configuration-file.html
<<<<<<< HEAD
process.env.CHROME_BIN = require('puppeteer').executablePath()
=======

>>>>>>> origin
module.exports = function (config) {
  config.set({
    basePath: '',
    frameworks: ['jasmine', '@angular-devkit/build-angular'],
    plugins: [
      require('karma-jasmine'),
      require('karma-chrome-launcher'),
      require('karma-jasmine-html-reporter'),
<<<<<<< HEAD
      require('karma-coverage'),
=======
      require('karma-coverage-istanbul-reporter'),
>>>>>>> origin
      require('@angular-devkit/build-angular/plugins/karma')
    ],
    client: {
      clearContext: false // leave Jasmine Spec Runner output visible in browser
    },
<<<<<<< HEAD
    jasmineHtmlReporter: {
      suppressAll: true // removes the duplicated traces
    },
    specReporter: {
      maxLogLines: 5,             // limit number of lines logged per test
      suppressErrorSummary: true, // do not print error summary
      suppressFailed: false,      // do not print information about failed tests
      suppressPassed: false,      // do not print information about passed tests
      suppressSkipped: true,      // do not print information about skipped tests
      showSpecTiming: false,      // print the time elapsed for each spec
      failFast: true,             // test would finish with error when a first fail occurs
      prefixes: {
        success: '    OK: ',      // override prefix for passed tests, default is '✓ '
        failure: 'FAILED: ',      // override prefix for failed tests, default is '✗ '
        skipped: 'SKIPPED: '      // override prefix for skipped tests, default is '- '
      }
    },
    reporters: ['progress'],
=======
    coverageIstanbulReporter: {
      dir: require('path').join(__dirname, './coverage/angularapp'),
      reports: ['html', 'lcovonly', 'text-summary'],
      fixWebpackSourcePaths: true
    },
    reporters: ['progress', 'kjhtml'],
>>>>>>> origin
    port: 9876,
    colors: true,
    logLevel: config.LOG_INFO,
    autoWatch: true,
<<<<<<< HEAD
    browsers: ['ChromeHeadless'],
    singleRun: true,
    restartOnFileChange: false
=======
    browsers: ['Chrome'],
    singleRun: false,
    restartOnFileChange: true
>>>>>>> origin
  });
};
