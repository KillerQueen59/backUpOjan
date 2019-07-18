package com.example.unittesting;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.doubleThat;
import static org.mockito.Mockito.ignoreStubs;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainPresenterTest {
    @Mock//
    private MainPresenter presenter;
    private MainView view;

    @Before
    public void setUp(){//
        view = mock(MainView.class);
        presenter = new MainPresenter(view);
    }

    @Test
    public void testVolumeWithIntegerInput() {
        double volume = presenter.volume(2,8,1);//
        assertEquals(16,volume,0.0001);//
    }
    @Test
    public void testVolumeWithDoubleInput(){
        double volume = presenter.volume(1.5,2.5,3.5);
        assertEquals(13.125,volume,0.0001);
    }
    @Test
    public void testVolumeWithZeroInput(){
        double volume = presenter.volume(0,0,0);
        assertEquals(0.0,volume,0.0001);
    }
    @Test
    public void testCalculateVolume(){
        presenter.calculateVolume(11.1,2.2,1);
        verify(view).showVolume(any(MainModel.class));
    }
}