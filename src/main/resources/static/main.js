function getPost(postId) {
    window.location.href = "/post/" + postId;
}

function getPostOnPage(page) {
    console.log(page);
    window.location.href = `?page=${page}`;
}

function filterPost() {
    const searchWord = document.getElementById("search-word").value;
    if (!searchWord) {
        return window.location.href = "/";
    }
    const searchCondition = document.getElementById("search-condition-list").selectedOptions[0].value;
    if (searchCondition == "title") {
        return window.location.href = `?title=${searchWord}`;
    }
    if (searchCondition == "nickname") {
        return window.location.href = `?nickname=${searchWord}`;
    }
}

function validateForm() {
    const pForm = document.form;
    const titleEmptyMsg = "제목을 입력해주세요.";
    const nicknameEmptyMsg = "닉네임을 입력해주세요.";
    const contentEmptyMsg = "글의 내용을 입력해주세요.";
    if (isEmpty(pForm.title, titleEmptyMsg) || isEmpty(pForm.nickname, nicknameEmptyMsg) || isEmpty(pForm.content, contentEmptyMsg)) {
        return false;
    }
    return true;
}

function deletePost(postId) {
    if (!confirm("글을 정말로 삭제하시겠습니까?")) {
        return;
    }
    fetch("/post/" + postId, {
        method: "DELETE",
        redirect: "follow"
    })
    .then((data) => {
        if (data.redirected) {
            window.location.replace(data.url);
        }
    });
}

function isEmpty(obj, msg) {
    const blankPattern = /\s/g
    if (obj.value.replace(blankPattern, "") == "") {
        alert(msg);
        return true;
    }
    return false;
}

function backToPrevPage() {
    window.history.back();
}