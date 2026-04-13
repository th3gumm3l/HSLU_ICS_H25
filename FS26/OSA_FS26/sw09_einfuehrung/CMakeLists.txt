cmake_minimum_required(VERSION 4.2)
project(sw09_einfuehrung)

set(CMAKE_CXX_STANDARD 20)

add_executable(sw09_einfuehrung Swap/SimpleSwap.cpp
        Swap/PointerSwap.cpp)