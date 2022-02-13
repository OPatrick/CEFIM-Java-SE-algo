package com.certification.trainer;

/**
 * (c) Patrick Brouillé
 * User: Patrick
 * Date: 12/02/2022
 * Time: 23:54
 */
// enum showing possible routes
enum Route {
    Create(1), Play(2);

    final int choice;
    Route(int c) {
        choice = c;
    }
}
