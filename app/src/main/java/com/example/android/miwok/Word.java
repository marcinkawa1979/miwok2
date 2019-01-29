package com.example.android.miwok;

/**
 * {@link Word} represents the vocabulary word that the user wont's to learn.
 * It contains a default translation and a Miwok translation of the word.
 * Created by Sir Tryton on 2018-03-12.
 */

public class Word {

    /*Default translation of the word*/
    private String mDefaultTranslation;

    /*Miwok translation of the word*/
    private String mMiwokTranslation;

    /* Image corresponding to appropriate word*/
    private int mImageResource = NO_IMAGE_PROVIDED;

    /* Sound corresponding to appropriate word */
    private int mSoundResource;

    /* Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResource=" + mImageResource +
                ", mSoundResource=" + mSoundResource +
                '}';
    }

    /**
     * Creates a new word object.
     *
     * @param soundResource is the sound corresponding to a word
     * @param defaultTranslation is the word in language that the user is familiar with (for example english)
     * @param miwokTranslation is the word in Miwok language
     */
   public Word(String defaultTranslation, String miwokTranslation, int soundResource) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mSoundResource = soundResource;

    }

   /**
     * Creates a new word object.
     *
     * @param soundResource is the sound corresponding to a word
     * @param imageResource is the image corresponding to a word
     * @param defaultTranslation is the word in language that the user is familiar with (for example english)
     * @param miwokTranslation is the word in Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResource, int soundResource) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResource = imageResource;
        this.mSoundResource = soundResource;

    }

    /**
     * Get the default translation of the ward
     * @return translated word
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the miwok translation of the word
     * @return
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the Image resource ID of the word
     * @return ID for an image
     */
    public int getImageResource() {
        return mImageResource;
    }

    /**
     * Get the sound resourced ID of the word
     * @return Id for a sound
     */
    public int getSoundResource(){ return mSoundResource;}


    public boolean hasImage(){
        return mImageResource != NO_IMAGE_PROVIDED;
    }
}
