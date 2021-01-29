@foreach ($pictures as $picture)
    <a href="{{ route('pictures.show', $picture) }}"><h2>{{ $picture->title }}</h2></a>
    <img src="{{ route('pictures.show', $picture) }}" alt="">
@endforeach