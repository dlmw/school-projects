<?php

namespace App\Http\Controllers;

use App\Http\Requests\PictureRequest;
use App\Picture;
use Aws\S3\PostObjectV4;
use Carbon\Carbon;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Str;

class PictureController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $pictures = Picture::all();
        return view('pictures.index', compact('pictures'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $adapter = Storage::disk('s3')->getDriver()->getAdapter();

        $client = $adapter->getClient();
        $bucket = $adapter->getBucket();
        $prefix = 'pictures/dlmw/';

        $acl = 'private';
        $expires = '+5 minutes';

        $key = $prefix.Str::uuid();
        
        $formInputs = [
            'acl' => $acl,
            'key' => $key,
        ];

        $options = [
            ['acl' => $acl],
            ['bucket' => $bucket],
            ['eq', '$key', $key],
        ];

        $postObject = new PostObjectV4($client, $bucket, $formInputs, $options, $expires);
        $attributes = $postObject->getFormAttributes();
        $inputs = $postObject->getFormInputs();

        return view('pictures.create', compact('attributes', 'inputs'));
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(PictureRequest $request)
    {
        $picture = new Picture();

        $picture->fill($request->all());

        $picture->save();

        return redirect()->route('pictures.index');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Picture  $picture
     * @return \Illuminate\Http\Response
     */
    public function show(Request $request, Picture $picture)
    {
        if (Str::startsWith($request->header('Accept'), 'image')) {
            return redirect(Storage::disk('s3')->temporaryUrl($picture->storage_path, Carbon::now()->addMinutes(5)));
            // return Storage::get($picture->storage_path);
        }

        return view('pictures.show', compact('picture'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Picture  $picture
     * @return \Illuminate\Http\Response
     */
    public function edit(Picture $picture)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Picture  $picture
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Picture $picture)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Picture  $picture
     * @return \Illuminate\Http\Response
     */
    public function destroy(Picture $picture)
    {
        $s3 = Storage::disk('s3');
        $s3->delete($picture->storage_path);

        $picture->delete();
        return redirect(route('pictures.index'));
    }
}
