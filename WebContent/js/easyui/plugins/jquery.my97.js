/**     
 * my97 - jQuery EasyUI     
 * Licensed under the GPL:     
 * http://www.gnu.org/licenses/gpl.txt     
 * Copyright 2013 Сѩת��ѩ [ caoguanghuicgh@163.com ] [http://www.easyui.info]     
 */      
(function ($) {       
    //���û��my97�ؼ��������֮��       
    (function () {       
        var hasmy97 = false;       
        var plugins = $.parser.plugins;       
        for (var i = plugins.length - 1; i > -1; i--) {       
            if (plugins[i] === "my97") {       
                hasmy97 = true;       
                break;       
            }       
        }       
        if (hasmy97 == false) {       
            $.parser.plugins[$.parser.plugins.length] = "my97";       
        }       
    })();       
      
    function init(target) {       
        $(target).addClass("my97-text")       
        var wrap = $("<span class=\"my97-wrap\"></span>").insertBefore(target);       
        wrap[0].appendChild(target);       
        var arrow = $("<span class=\"my97-arrow\"></span>").insertAfter(target);       
        return wrap;       
    };       
      
    /** 
     * ���¼����Դ���ԭ���my97�ؼ�     
     * @param  {[type]} target [description]     
     * @return {[type]}        [description]     
     */      
      
    function bindEvents(target) {       
        var data = $.data(target, "my97");       
        var opts = data.options;       
        var wrap = $.data(target, "my97").my97;       
        var input = wrap.find(".my97-text");       
        var arrow = wrap.find(".my97-arrow");       
      
        input.unbind(".my97");       
        arrow.unbind(".my97");       
        if (!opts.disabled) {       
            input.bind("click.my97", function (e) {       
                //TODO ����my97       
                WdatePicker(opts);       
            });       
            arrow.bind("click.my97",function () {       
                //TODO ����my97       
                WdatePicker($.extend({}, opts, {el:opts.id}));       
            }).bind('mouseenter.my97',       
                function (e) {       
                    $(this).addClass('my97-arrow-hover');       
                }).bind('mouseout.my97',       
                function (e) {       
                    $(this).removeClass('my97-arrow-hover');       
                }       
            );       
        }       
    };       
      
    /** 
     * ������     
     * @param  {document object} target ��������������     
     * @return {[type]}        [description]     
     */      
    function destroy(target) {       
        var input = $.data(target, "my97").my97.find("input.my97-text");       
        input.validatebox("destroy");       
        $.data(target, "my97").my97.remove();       
        $(target).remove();       
    };       
      
    function validate(target, doit) {       
        var opts = $.data(target, "my97").options;       
        var input = $.data(target, "my97").my97.find("input.my97-text");       
        input.validatebox(opts);       
        if (doit) {       
            input.validatebox("validate");       
        }       
    };       
      
    function initValue(target) {       
        var opts = $.data(target, "my97").options;       
        var input = $.data(target, "my97").my97.find("input.my97-text");       
        input.val(opts.value);       
    }       
      
    function setDisabled(target, disabled) {       
        var ops = $.data(target, "my97").options;       
        var my97 = $.data(target, "my97").my97;       
        var arrow = my97.find('.my97-arrow');       
        if (disabled) {       
            ops.disabled = true;       
            $(target).attr("disabled", true);       
            arrow.unbind('click.my97');       
            arrow.unbind('hover.my97');       
        } else {       
            ops.disabled = false;       
            $(target).removeAttr("disabled");       
            arrow.unbind('click.my97').bind('click.my97', function () {       
                WdatePicker(opts);       
            });       
            arrow.unbind('mouseenter.my97').unbind('mouseout').bind('mouseenter.my97',       
                function (e) {       
                    this.addClass('my97-arrow-hover');       
                }).bind('mouseenter.my97',       
                function (e) {       
                    this.removeClass('my97-arrow-hover');       
                }       
            );       
        }       
    };       
      
    /** 
     * ����������ȣ���Ҫ������ָboxģ�͵�width     
     * @param {document object} target ���ؿؼ��������     
     * @param {number} width  ���     
     */      
    function setWidth(target, width) {       
        var opts = $.data(target, "my97").options;       
        opts.width = width;       
        $(target).width(width);       
    }       
      
    function setValue(target, value) {       
        $(target).val(value);       
    }       
      
    function getValue(target) {       
        return $(target).val();       
    }       
      
    /** 
     * ��Ϊmy97ͼƬ������ʽ����Ҫid��������û������id������£�����һ��ΨһID     
     * @param {[type]} target [description]     
     */      
    function setId(target) {       
        var pre = "_easyui_my97_id_";       
        var opts = $.data(target, "my97").options;       
        opts.id = pre + $.fn.my97.defaults.count;       
        $(target).attr("id", opts.id);       
        $.fn.my97.defaults.count++;       
    }       
      
    $.fn.my97 = function (options, param) {       
        if (typeof options == 'string') {       
            return $.fn.my97.methods[options](this, param);       
        }       
        options = options || {};       
        return this.each(function () {       
            var state = $.data(this, 'my97');       
            var opts;       
            if (state) {       
                opts = $.extend(state.options, options);       
            } else {       
                opts = $.extend({}, $.fn.my97.defaults, $.fn.my97.parseOptions(this), options);       
                var wrap = init(this);       
                state = $.data(this, 'my97', {       
                    options:opts,       
                    my97:wrap       
                });       
            }       
            if (opts.id == undefined) {       
                setId(this);       
            }       
            setWidth(this, state.options.width);       
            setDisabled(this, state.options.disabled);       
            bindEvents(this);       
            validate(this);       
            initValue(this);       
        });       
    };       
    $.fn.my97.methods = {       
        options:function (jq) {       
            return $.data(jq[0], 'my97').options;       
        },       
        destroy:function (jq, param) {       
            return jq.each(function () {       
                destroy(this, param);       
            });       
        },       
        setWidth:function (jq, param) {       
            return jq.each(function () {       
                setWidth(this, param);       
            });       
        },       
        setValue:function (jq, param) {       
            setValue(jq[0], param);       
        },       
        getValue:function (jq, param) {       
            return getValue(jq[0]);       
        }       
    };       
    /** 
     * ����ת�������̳�validatebox�������     
     * @param  {document object} target ����my97�������     
     * @return {object}        �����б�     
     */      
    $.fn.my97.parseOptions = function (target) {       
        var t = $(target);       
        return $.extend({}, $.fn.validatebox.parseOptions(target), $.parser.parseOptions(target, ["width", "height", "weekMethod", "lang", "skin", "dateFmt", "realDateFmt", 'realTimeFmt', 'realFullFmt', 'minDate', 'maxDate', 'startDate',       
            {       
                doubleCalendar:"boolean",       
                enableKeyboard:"boolean",       
                enableInputMask:"boolean",       
                isShowWeek:"boolean",       
                highLineWeekDay:"boolean",       
                isShowClear:"boolean",       
                isShowOthers:"boolean",       
                readOnly:"boolean",       
                qsEnabled:"boolean",       
                autoShowQS:"boolean",       
                opposite:"boolean"      
            }, {       
                firstDayOfWeek:"number",       
                errDealMode:"number"      
            }]),       
            {       
                value:(t.val() || undefined),       
                disabled:(t.attr("disabled") ? true : undefined),       
                id:(t.attr("id") || undefined)       
            });       
    };       
    $.fn.my97.defaults = {       
        id:null,       
        count:0,       
        value:'',       
        width:109,       
        height:22,       
        disabled:false,       
        doubleCalendar:false,       
        enableKeyboard:true,       
        enableInputMask:true,       
        weekMethod:'ISO8601',       
        position:{},       
        lang:'auto',       
        skin:'default',       
        dateFmt:'yyyy-MM-dd',       
        realDateFmt:'yyyy-MM-dd',       
        realTimeFmt:'HH:mm:ss',       
        realFullFmt:'%Date %Time',       
        minDate:'1900-01-01 00:00:00',       
        maxDate:'2099-12-31 23:59:59',       
        startDate:'',       
        firstDayOfWeek:0,       
        isShowWeek:false,       
        highLineWeekDay:true,       
        isShowClear:true,       
        isShowOthers:true,       
        readOnly:false,       
        errDealMode:0,       
        qsEnabled:true,       
        autoShowQS:false,       
        opposite:false,       
        quickSel:[],       
        disabledDays:null,       
        disabledDates:null,       
        specialDates:null,       
        specialDays:null,       
        onpicking:function () {       
        },       
        onpicked:function () {       
        },       
        onclearing:function () {       
        },       
        oncleared:function () {       
        }       
    };       
})(jQuery);     
