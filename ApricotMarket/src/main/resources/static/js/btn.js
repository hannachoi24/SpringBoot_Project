$(function(){
  $(document).one('click', '.like-review', function(e) {
    $(this).html('<i class="fa fa-heart" aria-hidden="true"></i> 살리자 지구 마켓');
    $(this).children('.fa-heart').addClass('animate-like');
  });
});

