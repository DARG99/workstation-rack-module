CREATE TABLE T_TEAM (
                        id uuid PRIMARY KEY,
                        name varchar(30),
                        product varchar(30),
                        created_at timestamp default now(),
                        modified_at timestamp default now()
);

CREATE TABLE T_RACK (
                        id uuid PRIMARY KEY,
                        serial_number varchar(30) UNIQUE,
                        status varchar(30) CHECK (status IN ('AVAILABLE', 'BOOKED', 'UNAVAILABLE')),
                        team_id uuid,
                        default_location varchar(30),
                        created_at timestamp default now(),
                        modified_at timestamp default now(),
                        CONSTRAINT fk_team
                            FOREIGN KEY (team_id) REFERENCES T_TEAM(id)
                                ON DELETE SET NULL
);


CREATE TABLE T_TEAM_MEMBER(
                              id uuid PRIMARY KEY,
                              ctw_id varchar(30),
                              name varchar(30),
                              team_id uuid,
                              created_at timestamp default now(),
                              modified_at timestamp default now(),
                              CONSTRAINT fk_team
                                  FOREIGN KEY (team_id) REFERENCES T_TEAM(id)
                                      ON DELETE SET NULL

);

CREATE TABLE T_RACK_ASSET(
                             id uuid PRIMARY KEY,
                             asset_tag varchar(30),
                             rack_id uuid,
                             CONSTRAINT fk_rack
                                 FOREIGN KEY (rack_id) REFERENCES T_RACK(id)
                                     ON DELETE SET NULL


);


CREATE TABLE T_BOOKING(
                          id uuid primary key,
                          rack_id uuid,
                          requester_id uuid,
                          book_from date,
                          book_to date,
                          created_at timestamp default now(),
                          modified_at timestamp default now(),
                          CONSTRAINT fk_team_member
                              FOREIGN KEY (requester_id) REFERENCES T_TEAM_MEMBER(id)
                                  ON DELETE SET NULL,
                          CONSTRAINT fk_rack
                              FOREIGN KEY (rack_id) REFERENCES T_RACK(id)
                                  ON DELETE SET NULL
);



ALTER TABLE T_TEAM
    ADD COLUMN default_location varchar(50);