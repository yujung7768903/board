function getPost(postId) {
    window.location.href = '/post/' + postId;
}

function deletePost(postId) {
    if (!confirm("글을 정말로 삭제하시겠습니까?")) {
        return
    }
    fetch("/post/" + postId, {
        method: 'DELETE',
        redirect: 'follow'
    })
    .then((data) => {
        if (data.redirected) {
            window.location.replace(data.url);
        }
    });
}