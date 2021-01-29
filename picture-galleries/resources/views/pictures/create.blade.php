<form id="uploadPictureForm" action="{{ $attributes['action'] }}" method="{{ $attributes['method'] }}" enctype="{{ $attributes['enctype'] }}">
    @error('title')
        <div class="alert alert-message">{{ $message }}</div>
    @enderror
    @error('picture')
        <div class="alert alert-message">{{ $message }}</div>
    @enderror

    @foreach($inputs as $key => $input)
        <input type="hidden" name="{{ $key }}" value="{{ $input }}" />
    @endforeach

    <input id="title" type="text" name="title">
    <input id="file" type="file" name="file">
    <button type="submit">Submit</button>
</form>

<script>
    var inputs = {!!
        json_encode($inputs);
    !!}

    var uploadForm = document.getElementById("uploadPictureForm");

    uploadForm.addEventListener("submit", async function (event) {
        event.preventDefault();

        var url = uploadForm.action;
        var image = document.getElementById("file").files[0];
        var apiUrl = {!!json_encode(route('pictures.store'))!!}

        var formData = new FormData();
        for (key in inputs) {
            formData.append(key, inputs[key]);
        }

        formData.append("file", image);

        let res = await fetch(url, {
            method: "POST",
            body: formData
        });

        if (res.ok) {
            var token = {!! json_encode(csrf_token()) !!};

            var formData = new FormData();
            formData.append("storage_path", inputs.key);
            formData.append("title", document.getElementById("title").value);
            formData.append("_token", token);

            let res = await fetch(apiUrl, {
                method: "POST",
                body: formData
            });
        }
    });
</script>
