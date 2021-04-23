var main = {
  init : function () {
    var _this = this;
    $('#btn-save').on('click', function () {
      _this.save();
    });
  },
  save : function () {
    var data = {
      title: $('#title').val(),
      author: $('#author').val(),
      content: $('#content').val()
    };

    $.ajax({
      type: 'POST',
      url: '/api/v1/posts',
      datatype: 'json',
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(data)
    }).done(function() {
      alert('글이 등록되었습니다.');
      window.location.href = '/';
    })
  }
};

main.init();


var main2 = {
  init : function () {
    var _this = this;
    $('#btn-save2').on('click', function () {
      _this.save();
    });
  },
  save : function () {
    var data = {
      name: $('#name').val(),
      age: $('#age').val()
    };

    $.ajax({
      type: 'POST',
      url: '/api/v1/users',
      datatype: 'json',
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(data)
    }).done(function() {
      alert('사용자가 등록되었습니다.');
      window.location.href = '/';
    })
  }
};

main2.init();

var main3 = {
  init : function () {
    var _this = this;
    $('#btn-save3').on('click', function () {
      _this.save();
    });
  },
  save : function () {
    const id = $('#post_id').val();
    var data = {
      title: $('#title').val(),
      content: $('#content').val()
    };

    $.ajax({
      type: 'PUT',
      url: '/api/v1/posts/'+id,
      datatype: 'json',
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(data)
    }).done(function() {
      alert('게시글이 수정되었습니다.');
      window.location.href = '/';
    })
  }
};

main3.init();

var main4 = {
  init : function () {
    var _this = this;
    $('#delete-btn').on('click', function () {
      if(confirm("삭제하시겠습니까?")) {
        _this.delete();
      }
    });
  },
  delete : function () {
    var id = $('#post_id').val();

    $.ajax({
      type: 'DELETE',
      url: '/api/v1/posts/'+id,
      datatype: 'json',
      contentType: 'application/json; charset=utf-8',
    }).done(function() {
      alert('게시글이 삭제되었습니다.');
      window.location.href = '/';
    }).fail(function (error) {
      alert(JSON.stringify(error))
    })
  }
};

main4.init();




