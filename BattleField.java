import java.util.ArrayList;
import java.util.List;

public class BattleField {
    private List<HeroesEntity> heroes;
    private List<MonstersEntityFactory> monsters;
    private static BattleField currentBattle;

    public BattleField(List<HeroesEntity> heroes, List<MonstersEntityFactory> monsters) {
        this.heroes = heroes;
        this.monsters = monsters;
    }

    public static BattleField getCurrentBattle() {
        return currentBattle;
    }

    public void startBattle() {
        currentBattle = this;
        System.out.println("Battle begins!");

        while (!isBattleOver()) {
            // Execute a round of combat
            executeRound();
        }

        endBattle();
    }

    private void executeRound() {
        System.out.println("Round starts:");

        for (HeroesEntity hero : heroes) {
            if (!hero.isFainted()) {
                MonstersEntityFactory target = getRandomMonster();
                if (target != null) {
                    hero.attack(target);
                }
            }
        }
        for (MonstersEntityFactory monster : monsters) {
            if (!monster.isFainted()) {
                HeroesEntityFactory target = getRandomHero();
                if (target != null) {
                    monster.attack(target);
                }
            }
        }

        reviveAndRestore();

        System.out.println("Round ends.");
    }

    private void reviveAndRestore() {
        for (HeroesEntity hero : heroes) {
            if (hero.isFainted()) {
                hero.reviveWithHalfStats();
            } else {
                hero.reviveWithHalfStats();
            }
        }
    }

    private boolean isBattleOver() {
        return monsters.isEmpty() || heroes.stream().allMatch(HeroesEntity::isFainted);
    }

    private void endBattle() {
        if (monsters.isEmpty()) {
            System.out.println("Heroes win the battle!");
        } else {
            System.out.println("Monsters win the battle!");
        }
    }

    private HeroesEntity getRandomHero() {
        List<HeroesEntity> aliveHeroes = new ArrayList<>();
        for (HeroesEntity hero : heroes) {
            if (!hero.isFainted()) {
                aliveHeroes.add(hero);
            }
        }
        return aliveHeroes.isEmpty() ? null : aliveHeroes.get((int) (Math.random() * aliveHeroes.size()));
    }

    private MonstersEntityFactory getRandomMonster() {
        return monsters.isEmpty() ? null : monsters.get((int) (Math.random() * monsters.size()));
    }

    public void removeWarrior(Paladin paladin) {
    }
}
