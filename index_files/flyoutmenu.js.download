/* globals $ */

var flyoutMenu = flyoutMenu || {};
var hasTouch = function () {
  return "ontouchstart" in window;
};

(function(){

  flyoutMenu.flyoutTimer = null;

  flyoutMenu.initFlyoutMenu =  function(menuData, mode) {

    var showFlyoutMenu = function(e) {
      var index = e.data.index;
      var subMenuPanel, top, left;

      clearTimeout(flyoutMenu.flyoutTimer);

      menuData.forEach(function(data, i) {
        if (i !== index) {
          subMenuPanel = $("#ys_submenu_" + i);
          subMenuPanel.hide();
        }
      });


      var menuItem = $("#ys_menu_" + index).find("a");
      var offset = menuItem.offset();
      subMenuPanel = $("#ys_submenu_" + index);

      if (mode === "flyover_vertical") {
        top = offset.top;
        left = offset.left + menuItem.outerWidth() + 10;
      } else {
        top = offset.top + menuItem.outerHeight();
        left = offset.left + parseInt(menuItem.css("padding-left"));
      }

      subMenuPanel.css("top", top);
      subMenuPanel.css("left", left);

      subMenuPanel.fadeIn("fast");

      if (subMenuPanel.outerWidth() < 150) {
        subMenuPanel.css("width", 150);
      }
    };

    var hideFlyoutMenu = function(e) {
      var subMenuPanel = $("#ys_submenu_" + e.data.index);

      flyoutMenu.flyoutTimer = setTimeout(function(){
        subMenuPanel.fadeOut("fast");
      }, 300);
    };

    var menuTouch = function(e) {
      var index = e.data.index;
      var menuLink = e.data.menuLink;

      if (menuLink.hasClass("touched") || menuData[index].children.length === 0) {
        menuLink.dataNoClick = false;
      } else {
        var $document = $(document);
        menuLink.dataNoClick = true;
        menuLink.addClass("touched");

        var touchDocument = function(e) {
          if (!menuLink.is(e.target)) {
            $document.off("touchstart");
            menuLink.removeClass("touched");
            hideFlyoutMenu(e);
          }
        };

        $document.on("touchstart", {index: index}, touchDocument);
        showFlyoutMenu(e);
      }
    };

    var menuClick = function(e) {
      if (e.data.menuLink.dataNoClick) {
        e.preventDefault();
      }
    };

    menuData.forEach(function(data, i) {
      var menuItem = $("#ys_menu_" + i);
      var newSubMenuPanel = $("#ys_submenu_" + i);

      newSubMenuPanel.detach().appendTo("body");

      newSubMenuPanel.find("a").css({
        "font-size": menuItem.css("font-size"),
        "font-family": menuItem.css("font-family")
      });

      if (hasTouch()) {
        var menuLink = menuItem.find("a");
        menuLink.dataNoclick = false;
        menuLink.on("touchstart", {index: i, menuLink: menuLink}, menuTouch)
                .on("click", {menuLink: menuLink}, menuClick);
      }

      menuItem.mouseenter({index: i}, showFlyoutMenu);
      menuItem.mouseleave({index: i}, hideFlyoutMenu);

      newSubMenuPanel.mouseenter({index: i}, showFlyoutMenu);
      newSubMenuPanel.mouseleave({index: i}, hideFlyoutMenu);
    });
  };
})();
