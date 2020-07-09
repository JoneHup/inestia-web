$(function() {
  var wow = new WOW({
    boxClass: "wow",
    animateClass: "animated",
    offset: 100,
    mobile: true,
    live: true
  });
  wow.init();
  
  // queryByPage();

  if ($(".index-banner").length > 0) {
    var swiper = new Swiper(".index-banner .swiper-container", {
      slidesPerView: 1,
      spaceBetween: 0,
      effect: "fade",
      loop: true,
      parallax: true,
      autoplay: {
        delay: 6000,
        stopOnLastSlide: false,
        disableOnInteraction: true
      },
      speed: 1000,
      navigation: {
        nextEl: ".index-banner .swiper-button-next",
        prevEl: ".index-banner .swiper-button-prev"
      },
      pagination: {
        el: ".index-banner .swiper-pagination",
        clickable: true,
        renderBullet: function(index, className) {
          return '<span class="' + className + '">0' + (index + 1) + "</span>";
        }
      }
    });
  }

  if ($(".index-box1").length > 0) {
    var swiper2 = new Swiper(".index-box1 .swiper-container", {
      slidesPerView: 1,
      spaceBetween: 5,
      speed: 1000,
      loop: false,
      autoplay: {
        delay: 5000,
        stopOnLastSlide: false,
        disableOnInteraction: true
      },
      navigation: {
        nextEl: ".index-box1 .swiper-button-next",
        prevEl: ".index-box1 .swiper-button-prev"
      }
    });
  }

  if ($(".index-box3").length > 0) {
    var swiper3 = new Swiper(".index-box3 .swiper-container", {
      slidesPerView: "auto",
      spaceBetween: 0,
      speed: 1000,
      loop: false,
      autoplay: false,
      navigation: {
        nextEl: ".index-box3 .swiper-button-next",
        prevEl: ".index-box3 .swiper-button-prev"
      },
      on: {
        init: function() {
          $("#index-box3-swiper-count").html(this.slides.length);
        }
      },
      pagination: {
        el: ".index-box3 .swiper-pagination",
        clickable: true,
        renderBullet: function(index, className) {
          return '<span class="' + className + '">' + (index + 1) + "</span>";
        }
      }
    });
    $(window).resize(function() {
      swiper3Width();
    });
    swiper3Width();
  }

  function swiper3Width() {
    var $winWidth = $(window).width();
    var $index3Width = $(".index-box3 .container").width();
    if ($winWidth > $index3Width) {
      $(".index-box3-swiper .swiper-slide").css({
        // width: $index3Width + ($winWidth - $index3Width) / 2 + "px"
      });
      swiper3.update();
    }
  }

  if ($(".swiper-box7").length > 0) {
    var swiperBox7 = new Swiper(".swiper-box7 .swiper-container", {
      spaceBetween: 0,
      speed: 1000,
      slidesPerView: 2,
      loop: false,
      autoplay: false,
      navigation: {
        nextEl: ".swiper-box7 .swiper-button-next",
        prevEl: ".swiper-box7 .swiper-button-prev"
      },
      pagination: {
        el: ".swiper-box7 .swiper-pagination",
        clickable: true
      },
      breakpoints: {
        640: {
          slidesPerView: 1
        },
        768: {
          slidesPerView: 2
        }
      }
    });
  }
  //应用案例
  if ($(".page-cp-p6-box1-swiper").length > 0) {
    var swiperPage4 = new Swiper(".page-cp-p6-box1-swiper  .swiper-container", {
      effect: "coverflow",
      grabCursor: true,
      loop: true,
      centeredSlides: true,
      keyboard: true,
      spaceBetween: 0,
      slidesPerView: "auto",
      speed: 300,
      navigation: {
        nextEl: ".page-cp-p6-box1-swiper .swiper-button-next",
        prevEl: ".page-cp-p6-box1-swiper .swiper-button-prev"
      },
      coverflowEffect: {
        rotate: 0,
        stretch: 0,
        depth: 0,
        modifier: 3,
        slideShadows: false
      },
      breakpoints: {
        480: {
          spaceBetween: 0,
          centeredSlides: true
        }
      },
      simulateTouch: true,
      on: {
        init: function() {}
      }
    });
  }

  //发展历程
  if ($(".page-ab-box3-swiper").length > 0) {
    var galleryThumbs = new Swiper(".gallery-thumbs", {
      spaceBetween: 10,
      slidesPerView: 6,
      freeMode: true,
      watchSlidesVisibility: true,
      watchSlidesProgress: true,
      breakpoints: {
        640: {
          slidesPerView: 3
        },
        768: {
          slidesPerView: 5
        }
      }
    });
    var galleryTop = new Swiper(".gallery-top", {
      spaceBetween: 10,
      autoHeight: true,
      navigation: {
        nextEl: ".page-ab-box3-swiper .swiper-button-next",
        prevEl: ".page-ab-box3-swiper .swiper-button-prev"
      },
      thumbs: {
        swiper: galleryThumbs
      }
    });

    $("body").on("click", "#open-page-ab-box3-swiper", function() {
      $(this).addClass("layui-btn-disabled");
      $(".gallery-top .item").show();
      return false;
    });
  }

  //使命与愿景
  if ($(".page-ab-box1").length > 0) {
    $(".page-ab-box1 .item")
      .eq(1)
      .on("mouseover", function() {
        if (
          $(this)
            .parent()
            .hasClass("active")
        ) {
          $(this)
            .parent()
            .removeClass("active");
        } else {
          $(this)
            .parent()
            .addClass("active");
        }
      });
    $(".page-ab-box1 .item")
      .eq(1)
      .on("mouseout", function() {
        $(this)
          .parent()
          .removeClass("active");
      });
  }
  //案例
  if ($(".page-hy-box-case-swiper").length > 0) {
    var galleryThumbsCase = new Swiper(".gallery-thumbs-case", {
      spaceBetween: 10,
      slidesPerView: 4,
      direction: "vertical",
      freeMode: true,
      watchSlidesVisibility: true,
      watchSlidesProgress: true
    });
    var galleryTopCase = new Swiper(".gallery-top-case", {
      spaceBetween: 10,
      navigation: {
        nextEl: ".gallery-top-case .swiper-button-next",
        prevEl: ".gallery-top-case .swiper-button-prev"
      },
      thumbs: {
        swiper: galleryThumbsCase
      }
    });
  }
});

layui.use(["form", "util", "element"], function() {
  var form = layui.form;
  var util = layui.util;
  var layer = layui.layer;
  var element = layui.element;
  //固定块
  util.fixbar({
    css: { right: 20, bottom: 5 }
  });
  //
  $("body").on("click", "#daohang", function() {
    var par = $("#navli");
    var headerh = $("header").innerHeight();
    if (par.hasClass("active")) {
      par.removeClass("active");
      $(this).removeClass("active");
      par.css({ height: 0, opacity: 0 });
      $("body").css({ overflow: "inherit" });
    } else {
      $("body").css({ overflow: "hidden" });
      par.addClass("active");
      $(this).addClass("active");
      par.css({ height: $(window).innerHeight() - headerh + "px", opacity: 1 });
      //par.css({ 'height':  'auto', 'opacity': 1 });
    }
  });

  if ($(window).width() < 992) {
    $("#navli>ul>li").each(function(i) {
      if ($(this).find(".navli-nav").length > 0) {
        $(this).prepend('<div class="iright"></div>');
        //$(this).addClass("iright");
        $(this)
          .find(".iright")
          .eq(0)
          .click(function() {
            $(this)
              .nextAll(".navli-nav")
              .addClass("active");
            return false;
          });
      }
    });

    $(".fanhui").click(function() {
      $(this)
        .parents(".navli-nav")
        .removeClass("active");
      $("#navli>ul>li").removeClass("active");
    });

    $(".navli-nav li").each(function(i) {
      if ($(this).find("ul").length > 0) {
        $(this).prepend('<div class="iright"></div>');
        // $(this).addClass("iright");
        $(this)
          .find(".iright")
          .eq(0)
          .click(function() {
            if (
              $(this)
                .parent()
                .hasClass("active")
            ) {
              $(this)
                .parent()
                .removeClass("active");
              $(this)
                .nextAll("ul")
                .removeClass("active");
            } else {
              $(this)
                .parent()
                .addClass("active");
              $(this)
                .nextAll("ul")
                .addClass("active");
            }

            return false;
          });
      }
    });
  }

  //滚动
  var scorll_now = 0;
  $(window).scroll(function() {
    if ($(window).scrollTop() > 1) {
      if (!$("header").hasClass("fixed")) {
        $("header").addClass("fixed");
      }
    } else {
      $("header").removeClass("fixed");
    }

    scorll_now = $(window).scrollTop();
  });

  var imgOpts = $.extend(true, {}, $.fancybox.defaults, {
    caption: function(instance, item) {
      return $(this)
        .find("p")
        .html();
    }
  });
  function applyImgOpts() {
    $('[data-fancybox="images"]').fancybox(imgOpts);
  }
  applyImgOpts();

  //监听提交
  form.on("submit(formDemo)", function(data) {
    layer.msg(JSON.stringify(data.field));
    return false;
  });

  //video
  if ($(".video-js").length > 0) {
    videojs.options.flash.swf = "./video.js/video-js.swf";
    layui.each(function() {
      var videoId = $(this).prop("id");
      window.player = videojs(videoId, {
        fluid: true,
        plugins: {
          mux: {
            data: {
              property_key: "VJSISBEST",
              video_title: "The Boids!",
              video_id: 1
            }
          }
        }
      });
    });
  }

  //内页导行
  $("body").on("click", "#page-nav", function(event) {
    var $box = $("#page-nav-box");
    event.stopPropagation();
    if ($(this).hasClass("open")) {
      $box.slideUp();
      $(this).removeClass("open");
    } else {
      $box.slideDown();
      $(this).addClass("open");
    }
  });

  $("#page-nav-box .page_nav").each(function(i) {
    if ($(this).next("ul").length > 0) {
      $(this)
        .parent()
        .addClass("iright");
      $(this).click(function() {
        if (
          $(this)
            .parent()
            .hasClass("active")
        ) {
          $(this)
            .parent()
            .removeClass("active");
          $(this)
            .next("ul")
            .removeClass("active");
          $(this)
            .next("ul")
            .slideUp();
        } else {
          $(this)
            .parent()
            .addClass("active");
          $(this)
            .next("ul")
            .addClass("active");
          $(this)
            .next("ul")
            .slideDown();
        }
        return false;
      });
    }
  });

  //点击空白处菜单收回
  $("body").on("click", function() {
    var $box = $("#page-nav-box");
    $("#page-nav").removeClass("open");
    $box.slideUp();
  });

  $("#page-nav-right-select li").each(function() {
    if ($(this).find("ul").length > 0) {
      $(this)
        .find("a")
        .eq(0)
        .on("tap", function() {
          if (
            $(this)
              .parent()
              .hasClass("active")
          ) {
            $(this)
              .parent()
              .removeClass("active");
            $(this)
              .next("ul")
              .removeClass("active");
            $(this)
              .next("ul")
              .slideUp();
          } else {
            $(this)
              .parent()
              .addClass("active");
            $(this)
              .next("ul")
              .addClass("active");
            $(this)
              .next("ul")
              .slideDown();
          }
          return false;
        });

      $(this)
        .find("a")
        .eq(0)
        .click(function() {});
    }
  });

  if ($(".page-nav").length > 0) {
    var scorll_now2 = $(".page-nav").offset().top - $("header").height();
    $(window).resize(function() {
      scorll_now2 = $(".page-nav").offset().top - $("header").height();
    });
    $(window).scroll(function() {
      if ($(window).scrollTop() > scorll_now2) {
        $(".page-nav").addClass("fixed");
        $("header").addClass("no-fixed");
      } else {
        $(".page-nav").removeClass("fixed");
        $("header").removeClass("no-fixed");
      }
    });
    //滚动定位
    var headerHeight = $("header").outerHeight();
    var nrnavHeight = $(".page-nav").outerHeight();
    var nav1;
    var nav2;
    var nav3;
    var nav4;
    var nav5;
    var nav6;
    $(window).scroll(function() {
      nav1 = Math.floor(
        $(".scroll-nav")
          .eq(0)
          .offset().top -
          headerHeight -
          nrnavHeight
      );
      nav2 = Math.floor(
        $(".scroll-nav")
          .eq(1)
          .offset().top -
          headerHeight -
          nrnavHeight
      );
      nav3 = Math.floor(
        $(".scroll-nav")
          .eq(2)
          .offset().top -
          headerHeight -
          nrnavHeight
      );
      nav4 = Math.floor(
        $(".scroll-nav")
          .eq(3)
          .offset().top -
          headerHeight -
          nrnavHeight
      );
      nav5 = Math.floor(
        $(".scroll-nav")
          .eq(4)
          .offset().top -
          headerHeight -
          nrnavHeight
      );
        nav6 = Math.floor(
            $(".scroll-nav")
                .eq(5)
                .offset().top -
            headerHeight -
            nrnavHeight
        );
      if ($(window).scrollTop() < nav2) {
        $("#page-nav-md-a>a").removeClass("active");
        $("#page-nav-md-a>a")
          .eq(0)
          .addClass("active");
      } else if (
        $(window).scrollTop() >= nav2 &&
        $(window).scrollTop() < nav3
      ) {
        $("#page-nav-md-a>a").removeClass("active");
        $("#page-nav-md-a>a")
          .eq(1)
          .addClass("active");
      } else if (
        $(window).scrollTop() >= nav3 &&
        $(window).scrollTop() < nav4
      ) {
        $("#page-nav-md-a>a").removeClass("active");
        $("#page-nav-md-a>a")
          .eq(2)
          .addClass("active");
      } else if (
        $(window).scrollTop() >= nav4 &&
        $(window).scrollTop() < nav5
      ) {
        $("#page-nav-md-a>a").removeClass("active");
        $("#page-nav-md-a>a")
          .eq(3)
          .addClass("active");
      } else if ($(window).scrollTop() >= nav5&&
          $(window).scrollTop() < nav6) {
        $("#page-nav-md-a>a").removeClass("active");
        $("#page-nav-md-a>a")
          .eq(4)
          .addClass("active");
      }else if ($(window).scrollTop() >= nav6) {
          $("#page-nav-md-a>a").removeClass("active");
          $("#page-nav-md-a>a")
              .eq(5)
              .addClass("active");
      }
    });
    var roll;
    $("#page-nav-md-a>a").each(function(i) {
      $(this).click(function() {
        roll = Math.floor(
          $(".scroll-nav")
            .eq(i)
            .offset().top - nrnavHeight
        );
        $("html , body").animate({
          scrollTop: roll
        });
        return false;
      });
    });
  }

  //合作伙伴 tab
  if ($('[data-tab="hz"]').length > 0) {
    var $tabTo = $('[data-tab="hz"]').data("to");
    $('[data-tab="hz"] li').each(function() {
      var that = $(this);

      $(this).on("click", function() {
        $('[data-tab="hz"] li').removeClass("active");
        $(this).addClass("active");
        $("#" + $tabTo + " .tabs-item").removeClass("active");
        $("#" + $tabTo + " .tabs-item")
          .eq(that.index())
          .addClass("active");
        return false;
      });
    });
  }
  //合作弹窗
  if ($(".ck-layer").length > 0) {
    $(".ck-layer").on("click", function() {
      var $cklayerDiv = $(this).next(".info");
      layer.open({
        type: 1,
        skin: "ck-layer-class",
        shade: [0.3, "#000"],
        shadeClose: true,
        title: false,
        content: $cklayerDiv,
        cancel: function() {}
      });
      return false;
    });
  }
  //logo 灰白
  if ($(".huihover").length > 0) {
    $(".huihover").each(function() {
      $(this)
        .find("img")
        .css("filter", "grayscale(100%)");
    });
    $("body").on("mouseover", ".huihover", function() {
      $(this)
        .find("img")
        .css("filter", "grayscale(0%)");
    });
    $("body").on("mouseout", ".huihover", function() {
      $(this)
        .find("img")
        .css("filter", "grayscale(100%)");
    });
  }
  $(".page-hy-box-case .zanli").height($(".page-hy-box-case-swiper").height());

    $('#page-nav-md-a a').each(function(){
        if ($(this).hasClass('active')) {
            $(this).trigger('click');
        }
    });
});

function queryByPage() {
    $.ajax({
        url: "/home/news",
        type:'get',
        data:{
            order: asc,
            offset: 10,
            limit: 10
        },
        success:function(data){
            console.info(data);
        }
    });
}