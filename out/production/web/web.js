if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'web'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'web'.");
}if (typeof this['kotlinx-html-js'] === 'undefined') {
  throw new Error("Error loading module 'web'. Its dependency 'kotlinx-html-js' was not found. Please, check whether 'kotlinx-html-js' is loaded prior to 'web'.");
}var web = function (_, Kotlin, $module$kotlinx_html_js) {
  'use strict';
  var Kind_OBJECT = Kotlin.Kind.OBJECT;
  var unboxChar = Kotlin.unboxChar;
  var throwCCE = Kotlin.throwCCE;
  var toBoxedChar = Kotlin.toBoxedChar;
  var toDouble = Kotlin.kotlin.text.toDouble_pdl1vz$;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var Unit = Kotlin.kotlin.Unit;
  var trimIndent = Kotlin.kotlin.text.trimIndent_pdl1vz$;
  var equals = Kotlin.equals;
  var StringBuilder_init = Kotlin.kotlin.text.StringBuilder_init;
  var get_create = $module$kotlinx_html_js.kotlinx.html.dom.get_create_4wc2mh$;
  var td = $module$kotlinx_html_js.kotlinx.html.td_vlzo05$;
  var tr = $module$kotlinx_html_js.kotlinx.html.js.tr_9pz0lc$;
  var ensureNotNull = Kotlin.ensureNotNull;
  var IllegalArgumentException = Kotlin.kotlin.IllegalArgumentException;
  var toString = Kotlin.toString;
  var lazy = Kotlin.kotlin.lazy_klfg04$;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var IllegalArgumentException_init = Kotlin.kotlin.IllegalArgumentException_init_pdl1vj$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var listOf = Kotlin.kotlin.collections.listOf_i5x0yv$;
  var reversed = Kotlin.kotlin.collections.reversed_7wnvza$;
  var joinToString = Kotlin.kotlin.collections.joinToString_fmv235$;
  var toInt = Kotlin.kotlin.text.toInt_pdl1vz$;
  var numberToInt = Kotlin.numberToInt;
  var Regex_init = Kotlin.kotlin.text.Regex_init_61zpoe$;
  var take = Kotlin.kotlin.collections.take_ba2ldo$;
  var emptyList = Kotlin.kotlin.collections.emptyList_287e2$;
  var copyToArray = Kotlin.kotlin.collections.copyToArray;
  var round = Kotlin.kotlin.math.round_14dthe$;
  var split = Kotlin.kotlin.text.split_ip8yn$;
  var LinkedHashMap_init = Kotlin.kotlin.collections.LinkedHashMap_init_q3lmfv$;
  var trim = Kotlin.kotlin.text.trim_gw00vp$;
  var ArrayList_init_0 = Kotlin.kotlin.collections.ArrayList_init_ww73n8$;
  function CU() {
    CU_instance = this;
  }
  CU.prototype.hyphenIfNull_pdl1vj$ = function (data) {
    return data != null ? data : '-';
  };
  CU.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'CU',
    interfaces: []
  };
  var CU_instance = null;
  function CU_getInstance() {
    if (CU_instance === null) {
      new CU();
    }return CU_instance;
  }
  function H2X() {
    H2X_instance = this;
    this.KEY_XP_ID = 'xp_id';
    this.KEY_SWIPE_DATA = 'swipe_data';
    this.KEY_FUN_PERC = 'fun_perc';
  }
  H2X.prototype.getSwipeRows_eaqb6n$ = function (xpId, swipeData, funPerc) {
    var tmp$ = xpId == null;
    if (!tmp$) {
      var tmp$_0;
      var $receiver_0 = Kotlin.isCharSequence(tmp$_0 = xpId) ? tmp$_0 : throwCCE();
      var startIndex = 0;
      var endIndex = $receiver_0.length - 1 | 0;
      var startFound = false;
      while (startIndex <= endIndex) {
        var index = !startFound ? startIndex : endIndex;
        var match = unboxChar(toBoxedChar($receiver_0.charCodeAt(index))) <= 32;
        if (!startFound) {
          if (!match)
            startFound = true;
          else
            startIndex = startIndex + 1 | 0;
        } else {
          if (!match)
            break;
          else
            endIndex = endIndex - 1 | 0;
        }
      }
      tmp$ = Kotlin.subSequence($receiver_0, startIndex, endIndex + 1 | 0).toString().length === 0;
    }var tmp$_1 = tmp$ || swipeData == null;
    if (!tmp$_1) {
      var tmp$_2;
      var $receiver_0_0 = Kotlin.isCharSequence(tmp$_2 = swipeData) ? tmp$_2 : throwCCE();
      var startIndex_0 = 0;
      var endIndex_0 = $receiver_0_0.length - 1 | 0;
      var startFound_0 = false;
      while (startIndex_0 <= endIndex_0) {
        var index_0 = !startFound_0 ? startIndex_0 : endIndex_0;
        var match_0 = unboxChar(toBoxedChar($receiver_0_0.charCodeAt(index_0))) <= 32;
        if (!startFound_0) {
          if (!match_0)
            startFound_0 = true;
          else
            startIndex_0 = startIndex_0 + 1 | 0;
        } else {
          if (!match_0)
            break;
          else
            endIndex_0 = endIndex_0 - 1 | 0;
        }
      }
      tmp$_1 = Kotlin.subSequence($receiver_0_0, startIndex_0, endIndex_0 + 1 | 0).toString().length === 0;
    }var tmp$_3 = tmp$_1 || funPerc == null;
    if (!tmp$_3) {
      var tmp$_4;
      var $receiver_0_1 = Kotlin.isCharSequence(tmp$_4 = funPerc) ? tmp$_4 : throwCCE();
      var startIndex_1 = 0;
      var endIndex_1 = $receiver_0_1.length - 1 | 0;
      var startFound_1 = false;
      while (startIndex_1 <= endIndex_1) {
        var index_1 = !startFound_1 ? startIndex_1 : endIndex_1;
        var match_1 = unboxChar(toBoxedChar($receiver_0_1.charCodeAt(index_1))) <= 32;
        if (!startFound_1) {
          if (!match_1)
            startFound_1 = true;
          else
            startIndex_1 = startIndex_1 + 1 | 0;
        } else {
          if (!match_1)
            break;
          else
            endIndex_1 = endIndex_1 - 1 | 0;
        }
      }
      tmp$_3 = Kotlin.subSequence($receiver_0_1, startIndex_1, endIndex_1 + 1 | 0).toString().length === 0;
    }if (tmp$_3) {
      return null;
    }var funPercFloat = toDouble(funPerc);
    return SwipeRowUtils_getInstance().parseRows_9sobi5$(swipeData, funPercFloat);
  };
  H2X.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'H2X',
    interfaces: []
  };
  var H2X_instance = null;
  function H2X_getInstance() {
    if (H2X_instance === null) {
      new H2X();
    }return H2X_instance;
  }
  var SOURCE_HEADS;
  var SOURCE_TEMPO;
  function main$lambda(it) {
    window.location.reload();
    return Unit;
  }
  function main$lambda$lambda$lambda$lambda(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.slNo));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_0(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.requestedDate));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_1(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.inDate));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_2(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.inTime));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_3(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.outDate));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_4(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.outTime));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_5(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.workedHours));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_6(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(closure$swipeRow.funPerc.toString() + '%');
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_7(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(closure$swipeRow.getfFunHours().toString());
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_8(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(closure$swipeRow.getfNetWorkedHours().toString());
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_9(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.dayStatus));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda$lambda_10(closure$swipeRow) {
    return function ($receiver) {
      $receiver.unaryPlus_pdl1vz$(CU_getInstance().hyphenIfNull_pdl1vj$(closure$swipeRow.temporaryCardId));
      return Unit;
    };
  }
  function main$lambda$lambda$lambda(closure$swipeRow) {
    return function ($receiver) {
      td($receiver, void 0, main$lambda$lambda$lambda$lambda(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_0(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_1(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_2(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_3(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_4(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_5(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_6(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_7(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_8(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_9(closure$swipeRow));
      td($receiver, void 0, main$lambda$lambda$lambda$lambda_10(closure$swipeRow));
      return Unit;
    };
  }
  function main$lambda_0(closure$iXpId, closure$iFunPerc, closure$taSwipeData, closure$iDataSource, closure$firstPage, closure$secondPage) {
    return function (it) {
      var tmp$;
      var xpId = closure$iXpId.value;
      var funPerc = closure$iFunPerc.value;
      var swipeData = closure$taSwipeData.value;
      var dataSource = closure$iDataSource.value;
      console.log(trimIndent('\n' + '            XPID: ' + xpId + '\n' + '            funPerc : ' + funPerc + '\n' + '            dataSource : ' + dataSource + '\n' + '        '));
      it.preventDefault();
      try {
        if (equals(dataSource, SOURCE_HEADS)) {
          tmp$ = H2X_getInstance().getSwipeRows_eaqb6n$(xpId, swipeData, funPerc);
        } else {
          tmp$ = TempoToX_getInstance().getSwipeRows_61zpoe$(swipeData);
        }
        var swipeRows = tmp$;
        var dates = StringBuilder_init();
        if (swipeRows != null) {
          var closure$firstPage_0 = closure$firstPage;
          var closure$secondPage_0 = closure$secondPage;
          var tmp$_0, tmp$_1, tmp$_2;
          var tbSwipeRows = document.getElementById('tbSwipeDetails');
          var totalWorkedHours = 0.0;
          var totalFunHours = 0.0;
          var netWorkedHours = 0.0;
          tmp$_0 = swipeRows.iterator();
          while (tmp$_0.hasNext()) {
            var swipeRow = tmp$_0.next();
            if (swipeRow.getfNetWorkedHours() > 0) {
              dates.append_61zpoe$('{ ' + '"' + 'date' + '"' + ': ' + '"' + swipeRow.requestedDate + '"' + ', ' + '"' + 'durs' + '"' + ': ' + swipeRow.getfNetWorkedHours() + ' },');
            }totalWorkedHours += swipeRow.getfWorkedHours();
            totalFunHours += swipeRow.getfFunHours();
            netWorkedHours += swipeRow.getfNetWorkedHours();
            var tr_0 = tr(get_create(document), void 0, main$lambda$lambda$lambda(swipeRow));
            ensureNotNull(tbSwipeRows).appendChild(tr_0);
          }
          ensureNotNull(document.getElementById('pTotalWorkedHours')).innerHTML = 'Total Worked Hours: <b>' + totalWorkedHours + '<\/b>';
          ensureNotNull(document.getElementById('pTotalFunHours')).innerHTML = 'Total Fun Hours: <b>' + totalFunHours + '<\/b>';
          ensureNotNull(document.getElementById('pNetWorkedHours')).innerHTML = 'Net Worked Hours: <b>' + netWorkedHours + '<\/b>';
          (Kotlin.isType(tmp$_1 = document.getElementById('taScript'), HTMLTextAreaElement) ? tmp$_1 : throwCCE()).value = getAddScript(dates.toString(), xpId);
          (Kotlin.isType(tmp$_2 = document.getElementById('dScript'), HTMLTextAreaElement) ? tmp$_2 : throwCCE()).value = getDeleteScript(dates.toString(), xpId);
          closure$firstPage_0.hidden = true;
          closure$secondPage_0.hidden = false;
        }} catch (e) {
        if (Kotlin.isType(e, IllegalArgumentException)) {
          window.alert(ensureNotNull(e.message));
        } else
          throw e;
      }
      return Unit;
    };
  }
  function main() {
    var tmp$, tmp$_0, tmp$_1, tmp$_2, tmp$_3, tmp$_4, tmp$_5, tmp$_6;
    println('Hello World');
    var firstPage = Kotlin.isType(tmp$ = document.getElementById('firstPage'), HTMLDivElement) ? tmp$ : throwCCE();
    var secondPage = Kotlin.isType(tmp$_0 = document.getElementById('secondPage'), HTMLDivElement) ? tmp$_0 : throwCCE();
    firstPage.hidden = false;
    secondPage.hidden = true;
    var aHome = Kotlin.isType(tmp$_1 = document.getElementById('aHome'), HTMLAnchorElement) ? tmp$_1 : throwCCE();
    aHome.addEventListener('click', main$lambda);
    var iDataSource = Kotlin.isType(tmp$_2 = document.getElementById('data_source'), HTMLSelectElement) ? tmp$_2 : throwCCE();
    var iXpId = Kotlin.isType(tmp$_3 = document.getElementById('xp_id'), HTMLInputElement) ? tmp$_3 : throwCCE();
    var iFunPerc = Kotlin.isType(tmp$_4 = document.getElementById('fun_perc'), HTMLInputElement) ? tmp$_4 : throwCCE();
    var taSwipeData = Kotlin.isType(tmp$_5 = document.getElementById('swipe_data'), HTMLTextAreaElement) ? tmp$_5 : throwCCE();
    var fh2x = Kotlin.isType(tmp$_6 = document.getElementById('fh2x'), HTMLFormElement) ? tmp$_6 : throwCCE();
    fh2x.addEventListener('submit', main$lambda_0(iXpId, iFunPerc, taSwipeData, iDataSource, firstPage, secondPage));
  }
  function getDeleteScript(dates, xpId) {
    return '\n' + '        // load jquery' + '\n' + '\n' + "var myForm = document.getElementsByName('timelog')[0];" + '\n' + 'myForm.onsubmit = function () {' + '\n' + "    var popUpId = 'PopUp' + Math.random();" + '\n' + "    var w = window.open('', popUpId, 'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0,width=400,height=300,left = 312,top = 234');" + '\n' + '    this.target = popUpId;' + '\n' + '};' + '\n' + '\n' + '\n' + "var jq = document.createElement('script');" + '\n' + 'jq.src = ' + '"' + 'https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js' + '"' + ';' + '\n' + "document.getElementsByTagName('head')[0].appendChild(jq);" + '\n' + '\n' + 'var key = setInterval(function () {' + '\n' + '    if (jq) {' + '\n' + '        start();' + '\n' + '        clearInterval(key);' + '\n' + '    }' + '\n' + '}, 1000);' + '\n' + '\n' + '\n' + 'function start() {' + '\n' + '\n' + '      // date and duration' + '\n' + '  var dateAndDurs = [' + '\n' + '    ' + dates + '\n' + '  ];' + '\n' + '\n' + '    // my id' + '\n' + '    var myXPlannerID = ' + xpId + '\n' + '\n' + '\n' + '    ' + String.fromCharCode(36) + '(' + '"' + "form[name='timelog'] div#editObject table tbody tr" + '"' + ').each(function (index, item) {' + '\n' + '\n' + '        var iReportedDate = ' + String.fromCharCode(36) + "(item).find('td:nth-child(3) input');" + '\n' + '                        var iPerson1 = ' + String.fromCharCode(36) + "(item).find('td:nth-child(6) select');" + '\n' + '\n' + '        var repDate = ' + String.fromCharCode(36) + '(iReportedDate).val();' + '\n' + '                        var personId = parseInt(' + String.fromCharCode(36) + '(iPerson1).val());' + '\n' + '\n' + '        // looping each date' + '\n' + '        ' + String.fromCharCode(36) + '(dateAndDurs).each(function (index, item2) {' + '\n' + '            if (repDate === item2.date && personId=== myXPlannerID) {' + '\n' + '                ' + String.fromCharCode(36) + '(item).find(' + '"' + "input[type='checkbox']" + '"' + ").attr('checked', true);" + '\n' + '            }' + '\n' + '        });' + '\n' + '\n' + '\n' + '    });' + '\n' + '\n' + '    // submit' + '\n' + '    ' + String.fromCharCode(36) + '(' + '"' + "input[name='submit']" + '"' + ').click();' + '\n' + '\n' + '\n' + '}' + '\n' + '    ';
  }
  function getAddScript(dates, xpId) {
    return '\n' + '        // load jquery' + '\n' + "var myForm = document.getElementsByName('timelog')[0];" + '\n' + 'myForm.onsubmit = function () {' + '\n' + "    var popUpId = 'PopUp' + Math.random();" + '\n' + "    var w = window.open('', popUpId, 'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0,width=400,height=300,left = 312,top = 234');" + '\n' + '    this.target = popUpId;' + '\n' + '};' + '\n' + '\n' + '\n' + "var jq = document.createElement('script');" + '\n' + 'jq.src = ' + '"' + 'https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js' + '"' + ';' + '\n' + "document.getElementsByTagName('head')[0].appendChild(jq);" + '\n' + '\n' + 'var key = setInterval(function () {' + '\n' + '    if (jq) {' + '\n' + '        start();' + '\n' + '        clearInterval(key);' + '\n' + '    }' + '\n' + '}, 1000);' + '\n' + '\n' + '\n' + 'function start() {' + '\n' + '\n' + '    // date and duration' + '\n' + '    var dateAndDurs = [ ' + dates + '];' + '\n' + '\n' + '\n' + '    // find second last row' + '\n' + '    var secondLastRow = ' + String.fromCharCode(36) + '(' + '"' + "form[name='timelog'] div#editObject table tbody tr:last" + '"' + ').prev();' + '\n' + '\n' + '    // my id' + '\n' + '    var myXPlannerID = ' + xpId + ';' + '\n' + '\n' + '    // Selecting user' + '\n' + '    ' + String.fromCharCode(36) + '(secondLastRow).find(' + '"' + ':nth-child(6) select' + '"' + ').val(myXPlannerID);' + '\n' + '\n' + '\n' + '    // looping through' + '\n' + '    ' + String.fromCharCode(36) + '(dateAndDurs).each(function (index, item) {' + '\n' + '\n' + '        // Set date' + '\n' + '        ' + String.fromCharCode(36) + '(secondLastRow).find(' + '"' + ':nth-child(3) input' + '"' + ').val(item.date);' + '\n' + '\n' + '        // Set duration' + '\n' + '        ' + String.fromCharCode(36) + '(secondLastRow).find(' + '"' + ':nth-child(4) input' + '"' + ').val(item.durs);' + '\n' + '\n' + "        console.log('Submitting with ', item);" + '\n' + '\n' + '        // submit' + '\n' + '        ' + String.fromCharCode(36) + '(' + '"' + "input[name='submit']" + '"' + ').click();' + '\n' + '\n' + '    });' + '\n' + '\n' + '    location.reload();' + '\n' + '\n' + '\n' + '}' + '\n' + '\n' + '    ';
  }
  function SwipeRow(dataSource, slNo, requestedDate, dayStatus, inDate, inTime, outDate, outTime, workedHours, temporaryCardId, funPerc) {
    this.dataSource = dataSource;
    this.slNo = slNo;
    this.requestedDate = requestedDate;
    this.dayStatus = dayStatus;
    this.inDate = inDate;
    this.inTime = inTime;
    this.outDate = outDate;
    this.outTime = outTime;
    this.workedHours = workedHours;
    this.temporaryCardId = temporaryCardId;
    this.fWorkedHours_8g4iz7$_0 = lazy(SwipeRow$fWorkedHours$lambda(this));
    this.fFunHours_0 = 0;
    this.fNetWorkedHours_0 = 0;
    this.funPerc = this.inDate == null && this.outDate == null ? 0.0 : funPerc;
    this.fFunHours_0 = SwipeRowUtils_getInstance().calcFunHours_dob1fz$(this.fWorkedHours_0, this.funPerc);
    this.fNetWorkedHours_0 = this.fWorkedHours_0 - this.fFunHours_0;
  }
  Object.defineProperty(SwipeRow.prototype, 'fWorkedHours_0', {
    get: function () {
      return this.fWorkedHours_8g4iz7$_0.value;
    }
  });
  SwipeRow.prototype.getfWorkedHours = function () {
    return this.fWorkedHours_0;
  };
  SwipeRow.prototype.getfFunHours = function () {
    return this.fFunHours_0;
  };
  SwipeRow.prototype.getfNetWorkedHours = function () {
    return this.fNetWorkedHours_0;
  };
  SwipeRow.prototype.toString = function () {
    return 'SwipeRow{' + "slNo='" + this.slNo + String.fromCharCode(39) + ", requestedDate='" + this.requestedDate + String.fromCharCode(39) + ", dayStatus='" + this.dayStatus + String.fromCharCode(39) + ", inDate='" + this.inDate + String.fromCharCode(39) + ", inTime='" + this.inTime + String.fromCharCode(39) + ", outDate='" + this.outDate + String.fromCharCode(39) + ", outTime='" + this.outTime + String.fromCharCode(39) + ", workedHours='" + this.workedHours + String.fromCharCode(39) + ", temporaryCardId='" + this.temporaryCardId + String.fromCharCode(39) + ', fWorkedHours=' + toString(this.fWorkedHours_0) + ', fFunHours=' + toString(this.fFunHours_0) + ', fNetWorkedHours=' + toString(this.fNetWorkedHours_0) + String.fromCharCode(125);
  };
  function SwipeRow$fWorkedHours$lambda(this$SwipeRow) {
    return function () {
      if (equals(this$SwipeRow.dataSource, SOURCE_HEADS)) {
        return SwipeRowUtils_getInstance().calcWorkedHours_7efafy$(this$SwipeRow.workedHours);
      } else {
        var value = this$SwipeRow.workedHours != null;
        if (!value) {
          var message = 'When dataSource ' + this$SwipeRow.dataSource + ", workedHours can't be null";
          throw IllegalArgumentException_init(message.toString());
        }return toDouble(this$SwipeRow.workedHours);
      }
    };
  }
  SwipeRow.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'SwipeRow',
    interfaces: []
  };
  function SwipeRowUtils() {
    SwipeRowUtils_instance = this;
    this.MIN_THINKPALM_WORK_HOUR_0 = 6.0;
  }
  SwipeRowUtils.prototype.parseRows_9sobi5$ = function (swipeData, funPerc) {
    var tmp$;
    var swipeRows = ArrayList_init();
    var $receiver = Regex_init('\n').split_905azu$(swipeData, 0);
    var dropLastWhile$result;
    dropLastWhile$break: do {
      if (!$receiver.isEmpty()) {
        var iterator = $receiver.listIterator_za3lpa$($receiver.size);
        while (iterator.hasPrevious()) {
          if (!(iterator.previous().length === 0)) {
            dropLastWhile$result = take($receiver, iterator.nextIndex() + 1 | 0);
            break dropLastWhile$break;
          }}
      }dropLastWhile$result = emptyList();
    }
     while (false);
    var swipeRowStrings = copyToArray(dropLastWhile$result);
    for (tmp$ = 0; tmp$ !== swipeRowStrings.length; ++tmp$) {
      var swipeRow = swipeRowStrings[tmp$];
      var sr = this.parseRow_0(swipeRow, funPerc);
      println(sr);
      swipeRows.add_11rb$(sr);
    }
    return swipeRows;
  };
  SwipeRowUtils.prototype.parseRow_0 = function (swipeRow, funPerc) {
    var $receiver = Regex_init('\t').split_905azu$(swipeRow, 0);
    var dropLastWhile$result;
    dropLastWhile$break: do {
      if (!$receiver.isEmpty()) {
        var iterator = $receiver.listIterator_za3lpa$($receiver.size);
        while (iterator.hasPrevious()) {
          if (!(iterator.previous().length === 0)) {
            dropLastWhile$result = take($receiver, iterator.nextIndex() + 1 | 0);
            break dropLastWhile$break;
          }}
      }dropLastWhile$result = emptyList();
    }
     while (false);
    var columns = copyToArray(dropLastWhile$result);
    if (columns.length === 9) {
      var slNo = this.nullIfInvalidOrThrow_0(columns[0]);
      var requestedDate = this.convertToXPlannerDateFormat_0(this.nullIfInvalidOrThrow_0(columns[1]));
      var inDate = this.nullIfInvalid_0(columns[2]);
      var inTime = this.nullIfInvalid_0(columns[3]);
      var outDate = this.nullIfInvalid_0(columns[4]);
      var outTime = this.nullIfInvalid_0(columns[5]);
      var workedHours = this.nullIfInvalid_0(columns[6]);
      var dayStatus = this.nullIfInvalidOrThrow_0(columns[7]);
      var tempCardId = this.nullIfInvalid_0(columns[8]);
      return new SwipeRow(SOURCE_HEADS, slNo, requestedDate, dayStatus, inDate, inTime, outDate, outTime, workedHours, tempCardId, funPerc);
    } else {
      throw IllegalArgumentException_init('Invalid swipe lab. Column name must be 9 but got ' + toString(columns.length));
    }
  };
  SwipeRowUtils.prototype.convertToXPlannerDateFormat_0 = function (_date) {
    var date = _date;
    var tmp$ = date;
    date = Regex_init('/').replace_x2uqeu$(tmp$, '-');
    var tmp$_0 = date;
    var $receiver = Regex_init('-').split_905azu$(tmp$_0, 0);
    var dropLastWhile$result;
    dropLastWhile$break: do {
      if (!$receiver.isEmpty()) {
        var iterator = $receiver.listIterator_za3lpa$($receiver.size);
        while (iterator.hasPrevious()) {
          if (!(iterator.previous().length === 0)) {
            dropLastWhile$result = take($receiver, iterator.nextIndex() + 1 | 0);
            break dropLastWhile$break;
          }}
      }dropLastWhile$result = emptyList();
    }
     while (false);
    var chunks = copyToArray(dropLastWhile$result);
    var chunkList = listOf(chunks.slice());
    chunkList = reversed(chunkList);
    return joinToString(chunkList, '-');
  };
  SwipeRowUtils.prototype.nullIfInvalidOrThrow_0 = function (data) {
    var newData = data;
    newData = this.nullIfInvalid_0(ensureNotNull(newData));
    if (newData == null) {
      throw IllegalArgumentException_init("Data shouldn't be null");
    }return newData;
  };
  SwipeRowUtils.prototype.nullIfInvalid_0 = function (_data) {
    var tmp$;
    var tmp$_0;
    var $receiver_0 = Kotlin.isCharSequence(tmp$_0 = _data) ? tmp$_0 : throwCCE();
    var startIndex = 0;
    var endIndex = $receiver_0.length - 1 | 0;
    var startFound = false;
    while (startIndex <= endIndex) {
      var index = !startFound ? startIndex : endIndex;
      var match = unboxChar(toBoxedChar($receiver_0.charCodeAt(index))) <= 32;
      if (!startFound) {
        if (!match)
          startFound = true;
        else
          startIndex = startIndex + 1 | 0;
      } else {
        if (!match)
          break;
        else
          endIndex = endIndex - 1 | 0;
      }
    }
    var data = Kotlin.subSequence($receiver_0, startIndex, endIndex + 1 | 0).toString();
    if (equals(data, '-') || equals(data, '--:--')) {
      tmp$ = null;
    } else
      tmp$ = data;
    return tmp$;
  };
  SwipeRowUtils.prototype.calcWorkedHours_7efafy$ = function (workedHours) {
    if (workedHours == null) {
      return 0.0;
    }var $receiver = Regex_init(':').split_905azu$(workedHours, 0);
    var dropLastWhile$result;
    dropLastWhile$break: do {
      if (!$receiver.isEmpty()) {
        var iterator = $receiver.listIterator_za3lpa$($receiver.size);
        while (iterator.hasPrevious()) {
          if (!(iterator.previous().length === 0)) {
            dropLastWhile$result = take($receiver, iterator.nextIndex() + 1 | 0);
            break dropLastWhile$break;
          }}
      }dropLastWhile$result = emptyList();
    }
     while (false);
    var chunks = copyToArray(dropLastWhile$result);
    if (chunks.length === 2) {
      var $receiver_0 = chunks[0];
      var tmp$;
      var $receiver_0_0 = Kotlin.isCharSequence(tmp$ = $receiver_0) ? tmp$ : throwCCE();
      var startIndex = 0;
      var endIndex = $receiver_0_0.length - 1 | 0;
      var startFound = false;
      while (startIndex <= endIndex) {
        var index = !startFound ? startIndex : endIndex;
        var match = unboxChar(toBoxedChar($receiver_0_0.charCodeAt(index))) <= 32;
        if (!startFound) {
          if (!match)
            startFound = true;
          else
            startIndex = startIndex + 1 | 0;
        } else {
          if (!match)
            break;
          else
            endIndex = endIndex - 1 | 0;
        }
      }
      var hours = toInt(Kotlin.subSequence($receiver_0_0, startIndex, endIndex + 1 | 0).toString());
      var $receiver_1 = chunks[1];
      var tmp$_0;
      var $receiver_0_1 = Kotlin.isCharSequence(tmp$_0 = $receiver_1) ? tmp$_0 : throwCCE();
      var startIndex_0 = 0;
      var endIndex_0 = $receiver_0_1.length - 1 | 0;
      var startFound_0 = false;
      while (startIndex_0 <= endIndex_0) {
        var index_0 = !startFound_0 ? startIndex_0 : endIndex_0;
        var match_0 = unboxChar(toBoxedChar($receiver_0_1.charCodeAt(index_0))) <= 32;
        if (!startFound_0) {
          if (!match_0)
            startFound_0 = true;
          else
            startIndex_0 = startIndex_0 + 1 | 0;
        } else {
          if (!match_0)
            break;
          else
            endIndex_0 = endIndex_0 - 1 | 0;
        }
      }
      var minutes = toInt(Kotlin.subSequence($receiver_0_1, startIndex_0, endIndex_0 + 1 | 0).toString());
      var minutesInPerc = minutes > 0 ? this.toMinutePerc_0(minutes) : 0;
      var x = toDouble(hours.toString() + '.' + minutesInPerc);
      println(toString(workedHours) + ' -> ' + x);
      return x;
    } else {
      throw IllegalArgumentException_init('Worked hours time format in wrong format ' + toString(workedHours));
    }
  };
  SwipeRowUtils.prototype.toMinutePerc_0 = function (minutes) {
    var x = (minutes * 100 | 0) / 60.0;
    return numberToInt(round(x));
  };
  SwipeRowUtils.prototype.calcFunHours_dob1fz$ = function (fWorkedHours, _funPerc) {
    var funPerc = _funPerc;
    if (fWorkedHours < this.MIN_THINKPALM_WORK_HOUR_0) {
      funPerc = funPerc - funPerc * 50 / 100;
    }var fl = fWorkedHours * funPerc / 100;
    println('------------------------------');
    println('Worked Hours : ' + fWorkedHours);
    println('Fun Perc : ' + funPerc);
    println('Fun Hours: ' + fl);
    println('------------------------------');
    return fl;
  };
  SwipeRowUtils.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'SwipeRowUtils',
    interfaces: []
  };
  var SwipeRowUtils_instance = null;
  function SwipeRowUtils_getInstance() {
    if (SwipeRowUtils_instance === null) {
      new SwipeRowUtils();
    }return SwipeRowUtils_instance;
  }
  function TempoToX() {
    TempoToX_instance = this;
  }
  TempoToX.prototype.getSwipeRows_61zpoe$ = function (swipeData) {
    var tmp$, tmp$_0;
    var csvLines = split(swipeData, ['"\n']);
    var dateMap = LinkedHashMap_init();
    tmp$ = csvLines.size;
    for (var i = 1; i < tmp$; i++) {
      var csvRow = csvLines.get_za3lpa$(i);
      var csvColumns = split(csvRow, ['","']);
      println(csvColumns);
      var $receiver = csvColumns.get_za3lpa$(2);
      var tmp$_1;
      var hour = toDouble(trim(Kotlin.isCharSequence(tmp$_1 = $receiver) ? tmp$_1 : throwCCE()).toString());
      var $receiver_0 = split(csvColumns.get_za3lpa$(3), [' ']).get_za3lpa$(0);
      var tmp$_2;
      var workDate = trim(Kotlin.isCharSequence(tmp$_2 = $receiver_0) ? tmp$_2 : throwCCE()).toString();
      if (dateMap.get_11rb$(workDate) == null) {
        tmp$_0 = hour;
      } else {
        tmp$_0 = ensureNotNull(dateMap.get_11rb$(workDate)) + hour;
      }
      var value = tmp$_0;
      dateMap.put_xwzc9p$(workDate, value);
    }
    var index = {v: 1};
    var destination = ArrayList_init_0(dateMap.size);
    var tmp$_3;
    tmp$_3 = dateMap.entries.iterator();
    while (tmp$_3.hasNext()) {
      var item = tmp$_3.next();
      var tmp$_4;
      destination.add_11rb$(new SwipeRow(SOURCE_TEMPO, (tmp$_4 = index.v, index.v = tmp$_4 + 1 | 0, tmp$_4).toString(), item.key, 'Present', item.key, '00:00', item.key, '00:00', item.value.toString(), null, 0.0));
    }
    return destination;
  };
  TempoToX.$metadata$ = {
    kind: Kind_OBJECT,
    simpleName: 'TempoToX',
    interfaces: []
  };
  var TempoToX_instance = null;
  function TempoToX_getInstance() {
    if (TempoToX_instance === null) {
      new TempoToX();
    }return TempoToX_instance;
  }
  Object.defineProperty(_, 'CU', {
    get: CU_getInstance
  });
  Object.defineProperty(_, 'H2X', {
    get: H2X_getInstance
  });
  Object.defineProperty(_, 'SOURCE_HEADS', {
    get: function () {
      return SOURCE_HEADS;
    }
  });
  Object.defineProperty(_, 'SOURCE_TEMPO', {
    get: function () {
      return SOURCE_TEMPO;
    }
  });
  _.main = main;
  _.getDeleteScript_puj7f4$ = getDeleteScript;
  _.getAddScript_puj7f4$ = getAddScript;
  _.SwipeRow = SwipeRow;
  Object.defineProperty(_, 'SwipeRowUtils', {
    get: SwipeRowUtils_getInstance
  });
  Object.defineProperty(_, 'TempoToX', {
    get: TempoToX_getInstance
  });
  SOURCE_HEADS = 'HEADS';
  SOURCE_TEMPO = 'TEMPO';
  main();
  Kotlin.defineModule('web', _);
  return _;
}(typeof web === 'undefined' ? {} : web, kotlin, this['kotlinx-html-js']);