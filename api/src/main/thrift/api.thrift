namespace java com.myodov.sample_thrift_app.api

// exception SomeException { ... }

// service SomeService { ... }

enum Weapon {
    Sword = 1
    Bow = 2
}

struct WarriorInfo {
    1: optional Weapon weapon
    2: required i64 arrowsNumber
}

enum Spell {
    Fireball = 1
    Thunderbolt = 2
}

struct MageInfo {
    1: required set<Spell> spellbook
    2: required i64 mana
}

union ClassSpecificInfo {
    1: WarriorInfo warrior
    2: MageInfo mage
}

struct Hero {
    1: required string name
    2: required i64 hp
    3: required i64 xp
    4: ClassSpecificInfo classSpecificInfo
}

struct SomeInfo {
    1: required i64 first
    2: required i64 second
    3: required set<i64> sss
    4: required set<Spell> mmm
}

service CalculatorService {
    i32 multiply(1:i32 n1, 2:i32 n2),
}
