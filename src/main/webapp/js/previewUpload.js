//Will hold a reference to the image array after loading
var uploads;

//Tracks the currently selected image
var imageIndex;

//File reader for accessing images
var fileReader;

function previewUpload() {

    //Getting reference to file array held by input
    uploads = document.getElementById("uploadField").files;

    //Initializing image tracker
    imageIndex = 0;

    //Creating reader
    fileReader = new FileReader();

    //Loading user image file to image object on page
    loadImage();

    //Updating button status now that there is something to check against
    updateButtonStatus();
}

//Loads the image at the currently selected index as defined by the imageIndex variable
function loadImage() {

    //Getting reference to image object
    var preview = document.getElementById("imagePreview");

    //Limiting picture size to arbitrary size. Can be fleshed out later
    preview.height = 300;

    //Reading files into reader if any file is found
    if (uploads.length > 0) {
        fileReader.readAsDataURL(uploads[imageIndex]);

        //Waiting for reader to be ready before proceeding
        fileReader.onloadend = function () {
            //Assigning file to image object source
            preview.src = fileReader.result;
        }
    }
}

//Decrements image tracker, loads the relevant image and updates button status
function previousPicturePreview() {

    //Decrementing image tracker
    imageIndex--;

    //Updating buttons
    updateButtonStatus();

    //Loading currently selected image
    loadImage();
}

//Increments image tracker, loads the relevant image and updates button status
function nextPicturePreview() {

    //Incrementing image tracker
    imageIndex++;

    //Updating buttons
    updateButtonStatus();

    //Loading currently selected image
    loadImage();
}

function updateButtonStatus() {

    //Getting reference to previous and next buttons
    var previousButton = document.getElementById("previousPreviewItem");
    var nextButton = document.getElementById("nextPreviewItem");

    //Disabling previous button if first array item is selected
    if (imageIndex == 0) {
        previousButton.disabled = true;
    }
    else {
        previousButton.disabled = false;
    }

    //Disabling next button if last array item is selected
    if (imageIndex == uploads.length - 1) {
        nextButton.disabled = true;
    }
    else {
        nextButton.disabled = false;
    }
}