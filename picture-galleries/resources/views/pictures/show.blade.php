<h1>{{ $picture->title }}</h1>
<img src="{{ route('pictures.show', $picture)}}" alt="">
<form action="{{ route('pictures.destroy', $picture) }}" method="POST">
    @csrf
    @method("DELETE")
    <button type="submit">DELETE PICTURE</button>
</form>